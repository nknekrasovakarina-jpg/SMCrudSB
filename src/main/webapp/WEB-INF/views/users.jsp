<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>

<h2>Список пользователей</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Email</th>
        <th>Действия</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <!-- Кнопка Удалить -->
                <form method="post" action="/delete" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}" />
                    <input type="submit" value="Удалить" />
                </form>

                <!-- Форма Изменить -->
                <form method="post" action="/update" style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}" />
                    <input type="text" name="name" value="${user.name}" required />
                    <input type="email" name="email" value="${user.email}" required />
                    <input type="submit" value="Изменить" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>

<h2>Добавить нового пользователя</h2>
<form method="post" action="/add">
    Имя: <input type="text" name="name" required /><br />
    Email: <input type="email" name="email" required /><br />
    <input type="submit" value="Добавить" />
</form>

</body>
</html>