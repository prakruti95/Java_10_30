<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate Bill</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f4f7fb;
}

.bill-card{
    max-width:700px;
    margin:auto;
    margin-top:40px;
    background:white;
    border-radius:15px;
    padding:30px;
    box-shadow:0 0 15px rgba(0,0,0,0.1);
}

.title{
    text-align:center;
    margin-bottom:30px;
    color:#0d6efd;
    font-weight:bold;
}

.total-box{
    font-size:22px;
    font-weight:bold;
    color:green;
}

</style>

</head>

<body>

<div class="container">

    <div class="bill-card">

        <h2 class="title">
            Generate Bill
        </h2>
<form action="/saveBill"
      method="post"
      enctype="multipart/form-data">

            <input type="hidden"
                   name="mobileId"
                   value="${mobile.id}">

            <div class="mb-3">

                <label class="form-label">
                    Product Name
                </label>

                <input type="text"
                       class="form-control"
                       value="${mobile.model}"
                       readonly>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Price
                </label>

                <input type="text"
                       id="price"
                       class="form-control"
                       value="${mobile.price}"
                       readonly>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Customer Name
                </label>

                <input type="text"
                       name="customerName"
                       class="form-control"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Customer Mobile
                </label>

                <input type="text"
                       name="customerMobile"
                       class="form-control"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Quantity
                </label>

                <input type="number"
                       name="quantity"
                       id="quantity"
                       class="form-control"
                       value="1"
                       min="1"
                       max="${mobile.quantity}"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Total Amount
                </label>

                <input type="text"
                       id="totalAmount"
                       class="form-control total-box"
                       readonly>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Payment Type
                </label>

                <select name="paymentType"
                        id="paymentType"
                        class="form-select"
                        required>

                    <option value="">Select</option>
                    <option value="Cash">Cash</option>
                    <option value="Online">Online</option>

                </select>

            </div>

            <div id="onlineSection" style="display:none;">

                <div class="mb-3">

                    <label class="form-label">
                        Transaction ID
                    </label>

                    <input type="text"
                           name="transactionId"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">
                        Upload Screenshot
                    </label>

                  <input type="file"
       name="screenshot"
       class="form-control">

                </div>

            </div>

            <button type="submit"
                    class="btn btn-primary w-100">

                Generate Bill

            </button>

        </form>

    </div>

</div>

<script>

let quantityInput = document.getElementById("quantity");

let priceInput = document.getElementById("price");

let totalAmount = document.getElementById("totalAmount");

function calculateTotal(){

    let qty = quantityInput.value;

    let price = priceInput.value;

    totalAmount.value = qty * price;
}

calculateTotal();

quantityInput.addEventListener("input", calculateTotal);

document.getElementById("paymentType")
.addEventListener("change", function(){

    if(this.value === "Online"){

        document.getElementById("onlineSection")
        .style.display = "block";
    }
    else{

        document.getElementById("onlineSection")
        .style.display = "none";
    }
});

</script>

</body>
</html>