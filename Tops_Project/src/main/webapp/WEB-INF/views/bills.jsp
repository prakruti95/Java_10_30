<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Bills - Poojara Mobile Shop</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

<style>

body{
    background-color:#f5f7fa;
    font-family:Arial, Helvetica, sans-serif;
}

/* NAVBAR */

.navbar{
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

/* CARD */

.card-box{
    border:none;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

/* TABLE */

.table{
    vertical-align:middle;
}

.table thead{
    background:#0d6efd;
    color:white;
}

.page-title{
    font-weight:bold;
    color:#0d6efd;
}

.badge-payment{
    font-size:14px;
    padding:8px 12px;
}

.footer{
    background:#0d6efd;
    color:white;
    text-align:center;
    padding:15px;
    margin-top:40px;
}

</style>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container">

        <a class="navbar-brand fw-bold" href="/">
            <i class="fa-solid fa-mobile-screen-button"></i>
            Poojara Mobile Shop
        </a>

        <div>

            <a href="/" class="btn btn-light me-2">
                <i class="fa-solid fa-house"></i>
                Dashboard
            </a>

            <a href="/add" class="btn btn-success me-2">
                <i class="fa-solid fa-plus"></i>
                Add Mobile
            </a>

            <a href="/bills" class="btn btn-warning me-2">
                <i class="fa-solid fa-file-invoice"></i>
                Bills
            </a>

            <a href="/logout" class="btn btn-danger">
                <i class="fa-solid fa-right-from-bracket"></i>
                Logout
            </a>

        </div>

    </div>

</nav>

<!-- MAIN CONTENT -->

<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2 class="page-title">
            <i class="fa-solid fa-file-invoice-dollar"></i>
            Billing Records
        </h2>

        <span class="badge bg-success fs-6">
            Total Bills : ${bills.size()}
        </span>

    </div>

    <div class="card card-box">

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-bordered table-hover">

                    <thead>

                        <tr>

                            <th>ID</th>

                            <th>Customer Name</th>

                            <th>Mobile Number</th>

                            <th>Product</th>

                            <th>Qty</th>

                            <th>Price</th>

                            <th>Total</th>

                            <th>Payment</th>

                            <th>Transaction ID</th>

                            <th>Screenshot</th>

                            <th width="140">Action</th>

                        </tr>

                    </thead>

                    <tbody>

                        <c:forEach items="${bills}" var="b">

                            <tr>

                                <td>${b.id}</td>

                                <td>${b.customerName}</td>

                                <td>${b.customerMobile}</td>

                                <td>${b.productName}</td>

                                <td>
                                    <span class="badge bg-secondary">
                                        ${b.quantity}
                                    </span>
                                </td>

                                <td>₹ ${b.price}</td>

                                <td>
                                    <strong class="text-success">
                                        ₹ ${b.totalAmount}
                                    </strong>
                                </td>

                                <td>

                                    <c:if test="${b.paymentType == 'Cash'}">
                                        <span class="badge bg-success badge-payment">
                                            Cash
                                        </span>
                                    </c:if>

                                    <c:if test="${b.paymentType == 'Online'}">
                                        <span class="badge bg-primary badge-payment">
                                            Online
                                        </span>
                                    </c:if>

                                </td>

                                <td>

                                    <c:if test="${not empty b.transactionId}">
                                        ${b.transactionId}
                                    </c:if>

                                    <c:if test="${empty b.transactionId}">
                                        -
                                    </c:if>

                                </td>

                                <td>

                                    <c:if test="${not empty b.screenshot}">

                                        <a href="/uploads/${b.screenshot}"
                                           target="_blank"
                                           class="btn btn-sm btn-info text-white">

                                            <i class="fa-solid fa-image"></i>
                                            View

                                        </a>

                                    </c:if>

                                    <c:if test="${empty b.screenshot}">
                                        -
                                    </c:if>

                                </td>

                                <td>

                                    <a href="/printBill/${b.id}"
                                       class="btn btn-danger btn-sm">

                                        <i class="fa-solid fa-print"></i>
                                        Print

                                    </a>

                                </td>
           <td>

    <a href="/printbill/${b.id}"
       class="btn btn-primary btn-sm">
        Print PDF
    </a>

    <a href="https://wa.me/91${b.customerMobile}?text=Hello%20${b.customerName},%20Your%20bill%20for%20${b.productName}%20Amount:%20₹${b.totalAmount}"
       target="_blank"
       class="btn btn-success btn-sm">

        Share WhatsApp

    </a>

</td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </div>

        </div>

    </div>

</div>

<!-- FOOTER -->

<div class="footer">
    © 2026 Poojara Mobile Shop | Mobile Inventory Management System
</div>

</body>
</html>