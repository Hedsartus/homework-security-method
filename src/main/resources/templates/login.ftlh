<!DOCTYPE html>
<html>
<header>
    <title>Задача «Безопасные методы»</title>
</header>
    <body>
        <h3>Вход в систему</h3>
        <form action="/login" method="post">
            Email: <input type="email" name="username"/><br><br>
            Пароль: <input type="password" name="password"/><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Вход">
        </form>
        <a href="/registration">Зарегистрироваться</a>
    </body>
</html>