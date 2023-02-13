<!DOCTYPE html>
<html>
<header>
    <title>Задача «Безопасные методы»</title>
</header>
<body>
    <h3>Регистрация</h3>
    <form action="/registration" method="post">
        Имя:    <input type="text" name="name"/><br><br>
        Email: <input type="email" name="email"/><br><br>
        Пароль: <input type="password" name="password"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Зарегистрироваться"/>
    </form>
    <#if errorMsg??>
        <h3 style="color: red">${errorMsg}</h3>
    </#if>
</body>
</html>