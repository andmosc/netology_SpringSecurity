<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
        <meta charset="UTF-8"/>
        <title>Spring Security</title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<table>
    <tr><thead>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Возраст</th>
    </thead></tr>
<c:forEach var="empl" items="${employee}">
    <tr>
        <td>${empl.name}</td>
        <td>${empl.surname}</td>
        <td>${empl.age}</td>
    </tr>
</c:forEach>
    <p><a href="/address-book">Назад</a></p>
</table>
</body>
</html>
