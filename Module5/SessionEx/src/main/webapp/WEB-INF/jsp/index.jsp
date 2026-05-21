<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<f:form method="post" modelAttribute="login" action="login">


			<table>
			
			
			<c:if test="${logout!=null}">
			<tr>
				<td colspan="3">
					<c:out value="${logout}"></c:out>
				</td>
			</tr>
		</c:if>
		
		
		
		<c:if test="${error!=null}">
			<tr>
				<td colspan="3">
					<c:out value="${error}"></c:out>
				</td>
			</tr>
		</c:if>
			
			
			
				<tr>
					<td>
						<f:label path="name">Name:</f:label>
						<f:input path="name"/>
						<f:errors path="name"></f:errors>
					</td>
				</tr>
				
				<tr>
					<td>
						<f:label path="password">Password:</f:label>
						<f:input path="password"/>
						<f:errors path="password"></f:errors>
					</td>
				</tr>
				
				<tr>
			<td colspan="3">
				<input type="submit" name="submit" value="Login">
			</td>
		</tr>
		
			
			</table>


</f:form>

</body>
</html>