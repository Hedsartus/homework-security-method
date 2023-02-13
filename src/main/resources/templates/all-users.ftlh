<!DOCTYPE html>
<html>
<header>
    <title>Задача «Безопасные методы»</title>
</header>
<body>
<h3>Все пользователи</h3>
<hr>
<table style="margin: 20px auto; width: 60%;">
    <tr>
        <th colspan="2">Список юзеров</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.name}<br>${user.email}</td>
            <td><a href="/user?email=${user.email}">Подробнее</a></td>
        </tr>
    </#list>
</table>
</body>
</html>