<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        $(document).ready(function(){

            var typeOfLegalEntity = '${currentUser.getTypeOfLegalEntity()}';

            document.getElementById('typeOfLegalEntity').value = typeOfLegalEntity;
        });
    </script>

    <br>
    <h2>Окно редактирования</h2>
    <form method="post" action="/getEditUserPage?userId=${currentUser.getId()}">
        <table cellpadding="5 px" style="margin-left: 10px">
            <tr>
                <td>Фамилия</td>
                <td><input type="text" value="${currentUser.getLastname()}" id="lastname" name="lastname"></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" value="${currentUser.getFirstname()}" id="firstname" name="firstname"></td>
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
                <td><input type="text" value="${currentUser.getNameOfLegalEntity()}" id="nameOfLegalEntity" name="nameOfLegalEntity"</td>
            </tr>
            <tr>
                <td>Логин</td>
                <td><input type="text" value="${currentUser.getLogin()}" id="login" name="login"</td>
            </tr>
            <tr>
                <td>Почта</td>
                <td><input type="text" value="${currentUser.getEmail()}" id="email" name="email"</td>
            </tr>
            <#if isAdmin ??>
                <tr>
                    <td>Админ</td>
                    <td><input type="checkbox" id="admin" name="admin" style="zoom: 2"></td>
                </tr>
            </#if>
            <tr>
                <td><input type="submit" class="btn btn-primary" value="Редактировать"></td>
            </tr>
        </table>
    </form>
</@c.page>