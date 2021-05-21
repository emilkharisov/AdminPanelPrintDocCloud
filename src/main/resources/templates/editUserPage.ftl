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
                <#if lastnameError??>
                    <td><input type="text" value="${currentUser.getLastname()}" id="lastname" name="lastname" class="form-control is-invalid">
                    <label style="color: red">${lastnameError}</label>
                    </td>
                <#else>
                        <td><input type="text" value="${currentUser.getLastname()}" id="lastname" name="lastname"></td>
                </#if>
            </tr>
            <tr>
                <td>Имя</td>
                <#if firstnameError??>
                    <td><input type="text" value="${currentUser.getFirstname()}" id="firstname" name="firstname" class="form-control is-invalid">
                    <label style="color: red">${firstnameError}</label>
                    </td>
                <#else>
                    <td><input type="text" value="${currentUser.getFirstname()}" id="firstname" name="firstname"></td>
                </#if>
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
                        <input type="text" id="nameOfLegalEntity" value="${currentUser.getNameOfLegalEntity()}" name="nameOfLegalEntity" class="form-control is-invalid">
                        <label style="color: red">${nameOfLegalEntityError}</label>
                    <#else>
                        <input type="text" id="nameOfLegalEntity" value="${currentUser.getNameOfLegalEntity()}" name="nameOfLegalEntity">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Логин</td>
                <td>
                    <#if loginError??>
                        <input type="text" id="login" name="login" value="${currentUser.getLogin()}" class="form-control is-invalid">
                        <label style="color: red">${loginError}</label>
                    <#else>
                        <input type="text" value="${currentUser.getLogin()}" id="login" name="login">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Почта</td>
                <td>
                    <#if emailError??>
                        <input type="text" id="email" name="email" value="${currentUser.getEmail()}" class="form-control is-invalid">
                        <label style="color: red">${emailError}</label>
                    <#else>
                        <input type="text"  value="${currentUser.getEmail()}" id="email" name="email">
                    </#if>
                </td>
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