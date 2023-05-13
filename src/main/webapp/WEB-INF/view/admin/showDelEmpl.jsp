<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Spring Security</title>
</head>
<body>

<form:form action="showDetailsAddEmpl" modelAttribute="employee" method="post">

    <label>
        Список сотрудников:
        <form:select path="department">
            <form:options items="${listDepartments}"/>
        </form:select>
    </label>

    <br><br>
    <input type="submit" value="Удалить">

</form:form>

</body>

</html>