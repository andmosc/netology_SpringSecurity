<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <form:form  method="POST" modelAttribute="userForm">
        <h2>Регистрация</h2>

        <div>
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"/>
            <form:errors path="username"/>
                ${usernameError}
        </div>
             <br/>
        <div>
            <form:input type="password" path="password" placeholder="Password"/>
        </div>
            <br/>
        <div>
            <form:input type="password" path="confirmPassword"
                        placeholder="Confirm your password"/>
            <form:errors path="password" />
                ${passwordError}
        </div>
          <br/>
        <button type="submit">Зарегистрироваться</button>

    </form:form>
         <br/>
    <a href="/">Главная</a>

</div>

</body>
</html>