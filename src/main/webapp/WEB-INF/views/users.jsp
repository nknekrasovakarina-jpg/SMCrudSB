<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>Добавить пользователя</h2>
<form method="post" action="/add">
    Name: <input type="text" name="name" value="Jane Doe" required><br>
    Email: <input type="email" name="email" value="jane.doe@mail.ru" required><br>
    <input type="submit" value="Добавить">
</form>

<hr>

<h2>User List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>