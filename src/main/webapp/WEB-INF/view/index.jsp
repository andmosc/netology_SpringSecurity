<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Spring Security</title>
    </head>
    <body>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
      <h4><a href="/login">Войти</a></h4>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
      <p><a href="/administration">Администрирование</a></p>
    </sec:authorize>

      <p><a href="/address-book">Адресная книга работника</a></p>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a> </h4>
    </sec:authorize>
    </body>
</html>