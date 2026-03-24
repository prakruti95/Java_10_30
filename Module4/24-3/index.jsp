<%@page import="com.dao.Dao"%>
<%@page import="com.model.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%
    List<Model> list = Dao.viewdata();
    request.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee CRUD</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>

<body>

<div class="container mt-4">
    <h2>Manage Employees</h2>

    <table class="table table-bordered table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="m" items="${list}">
            <tr>
                <td>${m.id}</td>
                <td>${m.name}</td>
                <td>${m.email}</td>
                <td>${m.address}</td>
                <td>${m.phone}</td>
                <td>
                    <a href="edit.jsp?id=${m.id}" class="btn btn-warning btn-sm">Edit</a>
                </td>
                <td>
                    <a href="delete.jsp?id=${m.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <!-- Add Employee Form -->
    <h4>Add New Employee</h4>
    <form action="insert.jsp" method="post">
        <div class="form-group">
            <input type="text" name="name" placeholder="Name" class="form-control" required>
        </div>

        <div class="form-group">
            <input type="email" name="email" placeholder="Email" class="form-control" required>
        </div>

        <div class="form-group">
            <textarea name="address" placeholder="Address" class="form-control" required></textarea>
        </div>

        <div class="form-group">
            <input type="text" name="phone" placeholder="Phone" class="form-control" required>
        </div>

        <input type="submit" value="Add Employee" class="btn btn-success">
    </form>

</div>

</body>
</html>