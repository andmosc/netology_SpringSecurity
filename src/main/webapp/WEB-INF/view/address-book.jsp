<%@ page import="jdk.internal.icu.text.UnicodeSet" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Spring Security "User"</title>
</head>


<body>

    <c:forEach var="departament" items="${listDepartments}">

        <c:url var="depId" value="/listEmployee">
            <c:param name="id" value="${departament.key}"/>
        </c:url>

        <a href="${depId}">${departament.value}</a>

        <br>
    </c:forEach>

    <p><a href="/">Назад</a></p>

</body>
</html>