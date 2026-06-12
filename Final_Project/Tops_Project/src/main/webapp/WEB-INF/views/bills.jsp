<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Billing Records</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

<style>

body{
    background:#f5f7fa;
}

.navbar{
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.card-box{
    border:none;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

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

.footer{
    background:#0d6efd;
    color:white;
    text-align:center;
    padding:15px;
    margin-top:40px;
}

.action-btn{
    margin-bottom:5px;
    width:100%;
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
                Dashboard
            </a>

            <a href="/logout" class="btn btn-danger">
                Logout
            </a>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <div class="d-flex justify-content-between mb-4">

        <h2 class="page-title">
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
                            <th>Customer</th>
                            <th>Mobile</th>
                            <th>Product</th>
                            <th>Qty</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Payment</th>
                            <th>Transaction</th>
                            <th>Screenshot</th>
                            <th width="220">Actions</th>

                        </tr>

                    </thead>

                    <tbody>

                        <c:forEach items="${bills}" var="b">

                            <tr>

                                <td>${b.id}</td>

                                <td>${b.customerName}</td>

                                <td>${b.customerMobile}</td>

                                <td>${b.productName}</td>

                                <td>${b.quantity}</td>

                                <td>₹ ${b.price}</td>

                                <td>
                                    <strong class="text-success">
                                        ₹ ${b.totalAmount}
                                    </strong>
                                </td>

                                <td>

                                    <c:if test="${b.paymentType == 'Cash'}">

                                        <span class="badge bg-success">
                                            Cash
                                        </span>

                                    </c:if>

                                    <c:if test="${b.paymentType == 'Online'}">

                                        <span class="badge bg-primary">
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
                                           class="btn btn-info btn-sm">

                                            View

                                        </a>

                                    </c:if>

                                    <c:if test="${empty b.screenshot}">
                                        -
                                    </c:if>

                                </td>

                                <td>

                                    <a href="/printBill/${b.id}"
                                       class="btn btn-danger btn-sm action-btn">

                                        <i class="fa-solid fa-file-pdf"></i>
                                        Print PDF

                                    </a>

                                    <a href="https://wa.me/91${b.customerMobile}?text=Hello ${b.customerName}, Your bill for ${b.productName} Amount ₹${b.totalAmount}"
                                       target="_blank"
                                       class="btn btn-success btn-sm action-btn">

                                        <i class="fa-brands fa-whatsapp"></i>
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

<div class="footer">
    © 2026 Poojara Mobile Shop | Mobile Inventory System
</div>

</body>
</html>