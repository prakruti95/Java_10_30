<%@page import="java.util.List"%>
<%@page import="com.model.Student"%>

<%
	List<Student> list =
	(List<Student>)request.getAttribute("list");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Student Data</title>

</head>

<body>

<h1>Student Data</h1>

<a href="add">Add Student</a>

<br><br>

<table border="1" cellpadding="10">

<tr>

	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>City</th>
	<th>Action</th>

</tr>

<%
	for(Student s : list)
	{
%>

<tr>

	<td><%=s.getId()%></td>

	<td><%=s.getName()%></td>

	<td><%=s.getEmail()%></td>

	<td><%=s.getCity()%></td>

	<td>

		<a href="edit/<%=s.getId()%>">
			Edit
		</a>

		|

		<a href="delete/<%=s.getId()%>">
			Delete
		</a>

	</td>

</tr>

<%
	}
%>

</table>

</body>

</html>