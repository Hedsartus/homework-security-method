<!DOCTYPE html>
<html>
<header>
    <title>Задача «Безопасные методы»</title>
</header>
<body>
    <h3>Главная | <a href="/login">Войти</a></h3>
    <hr>
    <a href="/all-users">Все пользователи (READ or DELETE)</a><br><br>
    <#if user.email??>
        <a href="/user?email=${user.email}">Личный кабинет ${user.name}</a><br><br>
    </#if>
</body>
</html>
