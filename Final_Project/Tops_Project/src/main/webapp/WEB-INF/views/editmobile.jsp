<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Mobile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

<style>

body{
    background:#f5f7fa;
}

/* NAVBAR */

.navbar{
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.navbar-brand{
    font-size:24px;
}

/* CARD */

.card-box{
    border:none;
    border-radius:15px;
    box-shadow:0 4px 15px rgba(0,0,0,0.1);
    overflow:hidden;
}

.card-header{
    padding:20px;
}

.page-title{
    font-weight:bold;
}

/* FORM */

.form-label{
    font-weight:600;
    color:#333;
}

.form-control,
.form-select{
    border-radius:10px;
    padding:12px;
}

.form-control:focus,
.form-select:focus{
    box-shadow:none;
    border-color:#0d6efd;
}

.btn{
    border-radius:10px;
    padding:10px 18px;
    font-weight:600;
}

/* FOOTER */

.footer{
    background:#0d6efd;
    color:white;
    text-align:center;
    padding:15px;
    margin-top:50px;
    font-size:15px;
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

            <a href="/brand" class="btn btn-warning me-2">

                <i class="fa-solid fa-tag"></i>

                Brands

            </a>

            <a href="/category" class="btn btn-info text-white me-2">

                <i class="fa-solid fa-layer-group"></i>

                Categories

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

    <div class="row justify-content-center">

        <div class="col-md-7">

            <div class="card card-box">

                <div class="card-header bg-success text-white">

                    <h3 class="page-title mb-0">

                        <i class="fa-solid fa-pen-to-square"></i>

                        Edit Mobile

                    </h3>

                </div>

                <div class="card-body p-4">

                    <form action="/update" method="post">

                        <input type="hidden"
                               name="id"
                               value="${mobile.id}">

                        <!-- MODEL -->

                        <div class="mb-3">

                            <label class="form-label">

                                Mobile Model

                            </label>

                            <input type="text"
                                   name="model"
                                   value="${mobile.model}"
                                   class="form-control"
                                   placeholder="Enter Mobile Model"
                                   required>

                        </div>

                        <!-- PRICE -->

                        <div class="mb-3">

                            <label class="form-label">

                                Price

                            </label>

                            <input type="text"
                                   name="price"
                                   value="${mobile.price}"
                                   class="form-control"
                                   placeholder="Enter Price"
                                   required>

                        </div>

                        <!-- QUANTITY -->

                        <div class="mb-3">

                            <label class="form-label">

                                Quantity

                            </label>

                            <input type="text"
                                   name="quantity"
                                   value="${mobile.quantity}"
                                   class="form-control"
                                   placeholder="Enter Quantity"
                                   required>

                        </div>

                        <!-- BRAND -->

                        <div class="mb-3">

                            <label class="form-label">

                                Brand

                            </label>

                            <select name="brand.id"
                                    class="form-select"
                                    required>

                                <c:forEach items="${brands}" var="b">

                                    <option value="${b.id}"
                                    <c:if test="${mobile.brand.id == b.id}">
                                    selected
                                    </c:if>>

                                        ${b.brandName}

                                    </option>

                                </c:forEach>

                            </select>

                        </div>

                        <!-- CATEGORY -->

                        <div class="mb-4">

                            <label class="form-label">

                                Category

                            </label>

                            <select name="category.id"
                                    class="form-select"
                                    required>

                                <c:forEach items="${categories}" var="c">

                                    <option value="${c.id}"
                                    <c:if test="${mobile.category.id == c.id}">
                                    selected
                                    </c:if>>

                                        ${c.categoryName}

                                    </option>

                                </c:forEach>

                            </select>

                        </div>

                        <!-- BUTTONS -->

                        <div class="d-flex gap-3">

                            <button type="submit"
                                    class="btn btn-success">

                                <i class="fa-solid fa-floppy-disk"></i>

                                Update Mobile

                            </button>

                            <a href="/"
                               class="btn btn-secondary">

                                <i class="fa-solid fa-arrow-left"></i>

                                Back

                            </a>

                        </div>

                    </form>

                </div>

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