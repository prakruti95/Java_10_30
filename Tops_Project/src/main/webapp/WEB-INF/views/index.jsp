<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Mobile Inventory System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow-lg">

<div class="card-header bg-primary text-white d-flex justify-content-between">

<h3>Mobile Inventory System</h3>

<a href="/add" class="btn btn-light">Add Mobile</a>

</div>

<div class="card-body">

<table class="table table-bordered table-hover text-center">

<thead class="table-dark">
<tr>
<th>ID</th>
<th>Model</th>
<th>Price</th>
<th>Quantity</th>
<th>Brand</th>
<th>Category</th>
<th>Action</th>
</tr>
</thead>

<tbody>

<c:forEach items="${mobiles}" var="m">

<tr>
<td>${m.id}</td>
<td>${m.model}</td>
<td>${m.price}</td>
<td>${m.quantity}</td>
<td>${m.brand.brandName}</td>
<td>${m.category.categoryName}</td>

<td>
<a href="/delete/${m.id}" class="btn btn-danger btn-sm">Delete</a>
</td>
</tr>

</c:forEach>

</tbody>

</table>

</div>

</div>

</div>

</body>
</html>