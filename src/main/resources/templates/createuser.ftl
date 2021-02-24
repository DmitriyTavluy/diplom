<#import "parts/common.ftl" as c>

<@c.page "none">
<form method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <h3 style="color: #1e90ff">Добаление пользователя</h3>
    <input type="email" name="mail" placeholder="Почта">
    <input type="text" name="password" placeholder="Пароль">
    <input type="text" name="username" placeholder="Имя пользователя">
    <input type="checkbox" name="active" placeholder="Активность">
    <input type="text" name="roles" placeholder="Роль">
    <button class="btn btn-outline-primary" type="submit">Добавить</button>
</form>
</@c.page>