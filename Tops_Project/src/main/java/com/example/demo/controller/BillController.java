package com.example.demo.controller;
import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Mobile;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.MobileRepository;

import jakarta.servlet.http.HttpSession;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
@Controller
public class BillController {

    @Autowired
    MobileRepository mobileRepo;

    @Autowired
    BillRepository billRepo;

    @GetMapping("/bill/{id}")
    public String billPage(@PathVariable Integer id, Model model) {

        Mobile mobile = mobileRepo.findById(id).orElse(null);

        model.addAttribute("mobile", mobile);

        return "bill";
    }

    @PostMapping("/saveBill")
    public String saveBill(
            @RequestParam int mobileId,
            @RequestParam String customerName,
            @RequestParam(required = false) String customerMobile,
            @RequestParam int quantity,
            @RequestParam String paymentType,
            @RequestParam(required = false) String transactionId,
            @RequestParam(required = false) MultipartFile screenshot,
            HttpSession session) throws IOException {

        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        Mobile mobile = mobileRepo.findById(mobileId).orElse(null);

        if(mobile == null) {
            return "redirect:/";
        }

        // STOCK CHECK

        if(quantity > mobile.getQuantity()) {
            return "redirect:/bill/" + mobileId;
        }

        // CREATE BILL

        Bill bill = new Bill();

        bill.setCustomerName(customerName);

        bill.setCustomerMobile(customerMobile);

        bill.setProductName(mobile.getBrand().getBrandName()
                + " "
                + mobile.getModel());

        bill.setQuantity(quantity);

        bill.setPrice(mobile.getPrice());

        bill.setTotalAmount(mobile.getPrice() * quantity);

        bill.setPaymentType(paymentType);

        bill.setTransactionId(transactionId);

        // SAVE SCREENSHOT

        if(paymentType.equalsIgnoreCase("Online")
                && screenshot != null
                && !screenshot.isEmpty()) {

            String uploadDir = System.getProperty("user.dir")
                    + "/uploads/";

            File dir = new File(uploadDir);

            if(!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = System.currentTimeMillis()
                    + "_"
                    + screenshot.getOriginalFilename();

            File saveFile = new File(uploadDir + fileName);

            screenshot.transferTo(saveFile);

            bill.setScreenshot(fileName);
        }

        // SAVE BILL

        billRepo.save(bill);

        // REDUCE QUANTITY

        mobile.setQuantity(mobile.getQuantity() - quantity);

        mobileRepo.save(mobile);

        return "redirect:/";
    }
    @GetMapping("/printBill/{id}")
    public void printBill(@PathVariable int id,
                          HttpServletResponse response) throws Exception {

        Bill bill = billRepo.findById(id).orElse(null);

        if(bill == null) {
            return;
        }

        response.setContentType("application/pdf");

        response.setHeader("Content-Disposition",
                "attachment; filename=bill_" + id + ".pdf");

        Document document = new Document();

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font titleFont = new Font(Font.FontFamily.HELVETICA,
                22,
                Font.BOLD,
                BaseColor.BLUE);

        Font normalFont = new Font(Font.FontFamily.HELVETICA,
                14,
                Font.NORMAL);

        Font boldFont = new Font(Font.FontFamily.HELVETICA,
                14,
                Font.BOLD);

        Paragraph title =
                new Paragraph("Poojara Mobile Shop", titleFont);

        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Mobile Inventory Billing System", boldFont));
        document.add(new Paragraph("---------------------------------------------------"));

        document.add(new Paragraph("Bill ID : " + bill.getId(), normalFont));

        document.add(new Paragraph("Customer Name : "
                + bill.getCustomerName(), normalFont));

        document.add(new Paragraph("Customer Mobile : "
                + bill.getCustomerMobile(), normalFont));

        document.add(new Paragraph("Product Name : "
                + bill.getProductName(), normalFont));

        document.add(new Paragraph("Quantity : "
                + bill.getQuantity(), normalFont));

        document.add(new Paragraph("Price : ₹"
                + bill.getPrice(), normalFont));

        document.add(new Paragraph("Total Amount : ₹"
                + bill.getTotalAmount(), boldFont));

        document.add(new Paragraph("Payment Type : "
                + bill.getPaymentType(), normalFont));

        if(bill.getTransactionId() != null
                && !bill.getTransactionId().isEmpty()) {

            document.add(new Paragraph("Transaction ID : "
                    + bill.getTransactionId(), normalFont));
        }

        document.add(new Paragraph("---------------------------------------------------"));

        Paragraph thank =
                new Paragraph("Thank You Visit Again!", boldFont);

        thank.setAlignment(Element.ALIGN_CENTER);

        document.add(thank);

        document.close();
    }
    
    @GetMapping("/bills")
    public String showBills(Model model,
                            HttpSession session) {

        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        List<Bill> bills = billRepo.findAll();

        model.addAttribute("bills", bills);

        return "bills";
    }
}