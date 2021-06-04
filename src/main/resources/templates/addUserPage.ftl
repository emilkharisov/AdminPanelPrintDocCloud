<#import "parts/common.ftl" as c>
<@c.page>
    <br>
    <h2 style="margin-left: 10px">Добавить пользователя</h2>
    <form method="post" action="/getAddUserPage">
        <table cellpadding="5 px" style="margin-left: 10px">
            <tr>
                <td>Фамилия</td>
                <td>
                    <#if lastnameError??>
                        <input type="text" id="lastname" name="lastname" class="form-control is-invalid">
                        <label style="color: red">${lastnameError}</label>
                        <#else>
                            <input type="text" id="lastname" name="lastname">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Имя</td>
                <td>
                    <#if firstnameError??>
                        <input type="text" id="firstname" name="firstname" class="form-control is-invalid">
                        <label style="color: red">${firstnameError}</label>
                        <#else>
                            <input type="text" id="firstname" name="firstname">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Тип Юр.лица</td>
                <td>
                    <#if typeOfLegalEntityError??>
                        <select name="typeOfLegalEntity" id="typeOfLegalEntity" class="select-field">
                            <option disabled selected>Выберите тип юр.лица</option>
                            <option value="ИП">ИП</option>
                            <option value="ООО">ООО</option>
                        </select>
                        <label style="color: red">${typeOfLegalEntityError}</label>
                        <#else>
                            <select name="typeOfLegalEntity" id="typeOfLegalEntity" class="select-field">
                                <option disabled selected>Выберите тип юр.лица</option>
                                <option value="ИП">ИП</option>
                                <option value="ООО">ООО</option>
                            </select>
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Наименование Юр.лица</td>
                <td>
                    <#if nameOfLegalEntityError??>
                        <input type="text" id="nameOfLegalEntity" name="nameOfLegalEntity" class="form-control is-invalid">
                        <label style="color: red">${nameOfLegalEntityError}</label>
                        <#else>
                            <input type="text" id="nameOfLegalEntity" name="nameOfLegalEntity">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Логин</td>
                <td>
                    <#if loginError??>
                        <input type="text" id="login" name="login" class="form-control is-invalid">
                        <label style="color: red">${loginError}</label>
                        <#else>
                            <input type="text" id="login" name="login">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <#if emailError??>
                        <input type="text" id="email" name="email" class="form-control is-invalid">
                        <label style="color: red">${emailError}</label>
                        <#else>
                            <input type="text" id="email" name="email">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Админ</td>
                <td>
                    <input type="checkbox" id="admin" name="admin" style="zoom: 2">
                </td>
            </tr>
            <tr>
                <td><input type="submit" class="btn btn-primary" value="Добавить"></td>
            </tr>
        </table>
    </form>
</@c.page>