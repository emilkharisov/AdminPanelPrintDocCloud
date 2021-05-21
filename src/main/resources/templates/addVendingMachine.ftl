<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        function checkUniversity(param) {

            var value = param.value;

            if (value == 1){

                document.getElementById("univer").hidden = false;
            }
            else {
                document.getElementById("univer").hidden = true;
                document.getElementById("university").value = "";
            }

        }
    </script>
    <br>
    <h2 style="margin-left: 10px">Добавить аппарат</h2>
    <form method="post" action="/addVendingMachine">
        <table cellpadding="5 px" style="margin-left: 10px">
            <tr>
                <td>Владелец</td>
                <td>
                    <#if ownerError??>
                        <input list="user-list" name="owner">
                        <datalist id="user-list">
                            <option disabled>Выберите владельца</option>
                            <#if users ??>
                                <#list users as user>
                                    <option value=${user.getId()}>${user.getTypeOfLegalEntity()} ${user.getNameOfLegalEntity()}</option>
                                </#list>
                            </#if>
                            <label style="color: red">Поле обязательно</label>
                        </datalist>

                        <#else>
                    <input list="user-list" name="owner">
                    <datalist id="user-list">
                        <option disabled>Выберите владельца</option>
                        <#if users ??>
                            <#list users as user>
                                <option value=${user.getId()}>${user.getTypeOfLegalEntity()} ${user.getNameOfLegalEntity()}</option>
                            </#list>
                        </#if>
                    </datalist>
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Город</td>
                <td>
                    <#if cityError??>
                        <select name="city" id="city" class="select-field">
                            <option disabled selected>Выберите город</option>
                            <#list cityList as city>
                                <option value="${city.getId()}">${city.getCity()}</option>
                            </#list>
                        </select>
                        <label style="color: red">${cityError}</label>
                        <#else>
                            <select name="city" id="city" class="select-field">
                                <option disabled selected>Выберите город</option>
                                <#list cityList as city>
                                    <option value="${city.getId()}">${city.getCity()}</option>
                                </#list>
                            </select>
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Тип</td>
                <td>
                <#if typeOfLocationError??>
                        <select name="typeOfLocation" id="typeOfLocation" class="select-field" onchange="checkUniversity(this)">
                            <option disabled selected>Выберите тип</option>
                            <#list typeList as type>
                                <option value="${type.getId()}">${type.getType()}</option>
                            </#list>
                        </select>
                    <label style="color: red">${typeOfLocationError}</label>
                <#else>
                    <select name="typeOfLocation" id="typeOfLocation" class="select-field" onchange="checkUniversity(this)">
                        <option disabled selected>Выберите тип</option>
                        <#list typeList as type>
                            <option value="${type.getId()}">${type.getType()}</option>
                        </#list>
                    </select>
                </#if>
                </td>
            </tr>
            <tr>
                <td>Адрес</td>
                <td>
                    <#if addressError??>
                        <input type="text" id="address" name="address" class="form-control is-invalid">
                        <label style="color: red">${addressError}</label>
                    <#else>
                        <input type="text" id="address" name="address">
                    </#if>
                </td>
            </tr>
            <tr id="univer" hidden>
                <td>Университет</td>
                <td>
                    <select name="university" id="university" class="select-field">
                        <option disabled selected>Выберите университет</option>
                        <#list universityList as univer>
                            <option value="${univer.getId()}">${univer.getName()}</option>
                        </#list>
                </td>
            </tr>
            <tr>
                <td>Стоимость аренды</td>
                <td>
                    <#if rentCoastError??>
                        <input type="text" id="rentCoast" name="rentCoast" class="form-control is-invalid">
                        <label style="color: red">Поле обязательно</label>
                    <#else>
                        <input type="text" id="rentCoast" name="rentCoast">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>Цена за 1 лист</td>
                <td>
                    <#if coastForPrintError??>
                        <input type="text" id="coastForPrint" name="coastForPrint" class="form-control is-invalid">
                        <label style="color: red">Поле обязательно</label>
                    <#else>
                        <input type="text" id="coastForPrint" name="coastForPrint">
                    </#if>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" class="btn btn-primary" value="Добавить">
                </td>
            </tr>
        </table>
    </form>
</@c.page>
