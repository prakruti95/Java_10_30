<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

<title>Add Mobile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.error{
color:red;
font-size:14px;
}
</style>

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow-lg">

<div class="card-header bg-success text-white">
<h3>Add Mobile</h3>
</div>

<div class="card-body">

<form:form action="/save" method="post" modelAttribute="mobile">

<div class="mb-3">
<label>Model Name</label>
<form:input path="model" cssClass="form-control"/>
<form:errors path="model" cssClass="error"/>
</div>

<div class="mb-3">
<label>Price</label>
<form:input path="price" cssClass="form-control"/>
<form:errors path="price" cssClass="error"/>
</div>

<div class="mb-3">
<label>Quantity</label>
<form:input path="quantity" cssClass="form-control"/>
<form:errors path="quantity" cssClass="error"/>
</div>

<div class="mb-3">
<label>Brand</label>
<form:select path="brand.id" cssClass="form-select">
<form:option value="">Select Brand</form:option>

<c:forEach items="${brands}" var="b">
<option value="${b.id}">${b.brandName}</option>
</c:forEach>

</form:select>
</div>

<div class="mb-3">
<label>Category</label>
<form:select path="category.id" cssClass="form-select">
<form:option value="">Select Category</form:option>

<c:forEach items="${categories}" var="c">
<option value="${c.id}">${c.categoryName}</option>
</c:forEach>

</form:select>
</div>

<button class="btn btn-success">Save Mobile</button>
<a href="/" class="btn btn-secondary">Back</a>

</form:form>

</div>

</div>

</div>

</div>

</div>

</body>
</html>