<%@ page import="com.example.model.Student" %>

<%
Student s = (Student)request.getAttribute("student");
%>

<html>
<head>
<title>Edit Student</title>
</head>
<body>

<h2>Edit Student</h2>

<form action="updateStudent" method="post">

    <input type="hidden"
           name="id"
           value="<%= s.getId() %>">

    Name:
    <input type="text"
           name="name"
           value="<%= s.getName() %>">

    <br><br>

    Email:
    <input type="email"
           name="email"
           value="<%= s.getEmail() %>">

    <br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>