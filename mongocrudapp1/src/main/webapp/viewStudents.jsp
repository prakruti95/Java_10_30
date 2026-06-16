<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Student" %>

<%
List<Student> students =
    (List<Student>)request.getAttribute("students");
%>

<table border="1">

<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Action</th>
</tr>

<%
for(Student s : students){
%>

<tr>

<td><%= s.getName() %></td>

<td><%= s.getEmail() %></td>

<td>

<a href="editStudent?id=<%= s.getId() %>">
    Edit
</a>

&nbsp;|&nbsp;

<a href="deleteStudent?id=<%= s.getId() %>"
   onclick="return confirm('Delete this student?')">
    Delete
</a>

</td>

</tr>

<%
}
%>

</table>