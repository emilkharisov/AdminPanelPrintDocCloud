<#import "parts/common.ftl" as c>
<@c.page>
    <br>
    <h2 style="margin-left: 10px">Добавить пользователя</h2>
    <form method="post" action="/getAddUserPage">
        <table cellpadding="5 px" style="margin-left: 10px">
            <tr>
                <td>Фамилия</td>
                <td><input type="text" id="lastname" name="lastname"></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" id="firstname" name="firstname"></td>
            </tr>
            <tr>
                <td>Тип Юр.лица</td>
                <td>
                    <select name="typeOfLegalEntity" id="typeOfLegalEntity" class="select-field">
                        <option disabled selected>Выберите тип юр.лица</option>
                        <option value="ИП">ИП</option>
                        <option value="ООО">ООО</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Наименование Юр.лица</td>
                <td><input type="text" id="nameOfLegalEntity" name="nameOfLegalEntity"</td>
            </tr>
            <tr>
                <td>Логин</td>
                <td><input type="text" id="login" name="login"</td>
            </tr>
            <tr>
                <td>Почта</td>
                <td><input type="text" id="email" name="email"</td>
            </tr>
            <tr>
                <td>Админ</td>
                <td><input type="checkbox" id="admin" name="admin" style="zoom: 2"></td>
            </tr>
            <tr>
                <td><input type="submit" class="btn btn-primary" value="Добавить"></td>
            </tr>
        </table>
    </form>
</@c.page>