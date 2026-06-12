<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>

<style>

body{
    background-color:#f5f7fa;
}

.navbar{
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.card-box{
    border:none;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.page-title{
    font-weight:bold;
    color:#0d6efd;
}

.form-label{
    font-weight:600;
}

.form-control{
    height:50px;
    border-radius:10px;
}

.btn-save{
    height:50px;
    border-radius:10px;
    font-size:17px;
    font-weight:600;
}

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

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card card-box">

                <div class="card-body p-5">

                    <h2 class="page-title text-center mb-4">

                        <i class="fa-solid fa-layer-group"></i>

                        Add Category

                    </h2>

                    <form action="/saveCategory" method="post">

                        <div class="mb-4">

                            <label class="form-label">

                                Category Name

                            </label>

                            <input type="text"
                                   name="categoryName"
                                   class="form-control"
                                   placeholder="Enter Category Name"
                                   required>

                        </div>

                        <button type="submit"
                                class="btn btn-primary w-100 btn-save">

                            <i class="fa-solid fa-floppy-disk"></i>

                            Save Category

                        </button>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>


</body>
</html>