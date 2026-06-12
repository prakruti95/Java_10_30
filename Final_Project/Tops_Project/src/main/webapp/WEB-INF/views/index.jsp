<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile Inventory System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

<style>

body{
    background-color:#f5f7fa;
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

/* BUTTON */

.btn-action{
    min-width:80px;
}

/* TITLE */

.page-title{
    font-weight:bold;
    color:#0d6efd;
}

/* EMPTY DATA */

.empty-data{
    text-align:center;
    padding:40px;
    color:gray;
}

/* SEARCH */

.search-box{
    background:white;
    padding:20px;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
    margin-bottom:25px;
}

/* FOOTER */

.footer{
    background:#0d6efd;
    color:white;
    text-align:center;
    padding:12px;
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

            Mobile Inventory

        </a>

        <div>

            <a href="/add" class="btn btn-light me-2">

                <i class="fa-solid fa-plus"></i>

                Add Product

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

    <!-- DASHBOARD HEADER -->

    <div class="d-flex justify-content-between align-items-center mb-4 flex-wrap">

        <h2 class="page-title mb-3">

            Mobile Inventory Dashboard

        </h2>

        <span class="badge bg-success fs-6">

            Total Products : ${mobiles.size()}

        </span>

    </div>

    <!-- SEARCH BAR -->

    <div class="search-box">

        <form action="/search" method="get" class="row g-3">

            <div class="col-md-3">

                <select name="type" class="form-select">

                    <option value="model">Search By Model</option>

                    <option value="brand">Search By Brand</option>

                    <option value="category">Search By Category</option>

                </select>

            </div>

            <div class="col-md-6">

                <input type="text"
                       name="keyword"
                       class="form-control"
                       placeholder="Enter search keyword..."
                       required>

            </div>

            <div class="col-md-3 d-flex gap-2">

                <button type="submit" class="btn btn-primary w-100">

                    <i class="fa-solid fa-magnifying-glass"></i>

                    Search

                </button>

                <a href="/" class="btn btn-secondary w-100">

                    Reset

                </a>

            </div>

        </form>

    </div>

    <!-- PRODUCT TABLE -->

    <div class="card card-box">

        <div class="card-body">

            <c:if test="${empty mobiles}">

                <div class="empty-data">

                    <h4>No Products Available</h4>

                    <p>Add your first mobile product.</p>

                    <a href="/add" class="btn btn-primary">

                        <i class="fa-solid fa-plus"></i>

                        Add Mobile

                    </a>

                </div>

            </c:if>

            <c:if test="${not empty mobiles}">

                <div class="table-responsive">

                    <table class="table table-bordered table-hover">

                        <thead>

                            <tr>

                                <th>ID</th>

                                <th>Brand</th>

                                <th>Category</th>

                                <th>Model</th>

                                <th>Price</th>

                                <th>Quantity</th>

                                <th width="180">Action</th>

                            </tr>

                        </thead>

                        <tbody>

                            <c:forEach items="${mobiles}" var="m">

                                <tr>

                                    <td>${m.id}</td>

                                    <td>${m.brand.brandName}</td>

                                    <td>${m.category.categoryName}</td>

                                    <td>${m.model}</td>

                                    <td>

                                        ₹ ${m.price}

                                    </td>

                                    <td>

                                        <span class="badge bg-secondary">

                                            ${m.quantity}

                                        </span>

                                    </td>
                                    
                                    <td>

    <div class="d-flex gap-2 flex-wrap">

      <a href="/bill/${m.id}"
           class="btn btn-primary btn-sm">

            Generate Bill

        </a>
       <a href="/bills" class="btn btn-dark me-2">

    <i class="fa-solid fa-file-invoice"></i>

    Bills

</a>

        <a href="/edit/${m.id}"
           class="btn btn-success btn-sm">

            <i class="fa-solid fa-pen-to-square"></i>
            Edit

        </a>

        <a href="/delete/${m.id}"
           class="btn btn-danger btn-sm"
           onclick="return confirm('Are you sure to delete this product?')">

            <i class="fa-solid fa-trash"></i>
            Delete

        </a>

    </div>

</td>

                                </tr>

                            </c:forEach>

                        </tbody>

                    </table>

                </div>

            </c:if>

        </div>

    </div>

</div>


</body>
</html>