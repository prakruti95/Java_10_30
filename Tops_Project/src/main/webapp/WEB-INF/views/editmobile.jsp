<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Edit Mobile</title>
</head>

<body>

<h1>Edit Mobile</h1>

<form action="/update" method="post">

<input type="hidden" name="id" value="${mobile.id}">

Model:
<input type="text" name="model" value="${mobile.model}">
<br><br>

Price:
<input type="text" name="price" value="${mobile.price}">
<br><br>

Quantity:
<input type="text" name="quantity" value="${mobile.quantity}">
<br><br>

Brand:

<select name="brand.id">

<c:forEach items="${brands}" var="b">

<option value="${b.id}"
<c:if test="${mobile.brand.id == b.id}">
selected
</c:if>
>
${b.brandName}
</option>

</c:forEach>

</select>

<br><br>

Category:

<select name="category.id">

<c:forEach items="${categories}" var="c">

<option value="${c.id}"
<c:if test="${mobile.category.id == c.id}">
selected
</c:if>
>
${c.categoryName}
</option>

</c:forEach>

</select>

<br><br>

<input type="submit" value="Update">

</form>

</body>
</html>