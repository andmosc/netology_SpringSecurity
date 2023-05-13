<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Spring Security "Administrator"</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>

    <table>
        <tr><thead>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Департамент</th>
            <th></th>
            <th></th>
        </thead></tr>

        <c:forEach var="empl" items="${empl}">

            <c:url var="updateInfo" value="/updateEmployee">
                <c:param name="empId" value="${empl.id}"/>
            </c:url>

            <c:url var="delInfo" value="/delEmployee">
                <c:param name="empId" value="${empl.id}"/>
            </c:url>

            <tr>
                <td>${empl.name}</td>
                <td>${empl.surname}</td>
                <td>${empl.age}</td>
                <td>${empl.department.name}</td>
                <td>
                    <input type="button" value="Изменить"
                           onclick="window.location.href='${updateInfo}'"/>
                </td>
                <td>
                    <input type="button" value="Удалить"
                           onclick="window.location.href='${delInfo}'"/>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

<br>

<input type="button" value="Добавить"
       onclick="window.location.href ='addNewEmployee'">

    <p><a href="/">Назад</a></p>

</body>
</html>