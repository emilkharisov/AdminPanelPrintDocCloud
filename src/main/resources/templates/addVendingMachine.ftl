<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        function checkUniversity(param) {

            var value = param.value;

            if (value == 1){

                document.getElementById("univer").hidden = false;


            }

        }
    </script>
    <br>
    <h2>Добавить аппарат</h2>
    <form method="post" action="/addVendingMachine">
        <table>
            <tr>
                <td>Владелец</td>
                <td>
                    <input list="user-list" name="owner">
                    <datalist id="user-list">
                        <option disabled>Выберите владельца</option>
                        <#if users ??>
                            <#list users as user>
                                <option value=${user.getId()}>${user.getTypeOfLegalEntity()} ${user.getNameOfLegalEntity()}</option>
                            </#list>
                        </#if>
                    </datalist>
                </td>
            </tr>
            <tr>
                <td>Город</td>
                <td>
                    <select name="city" id="city" class="select-field">
                        <option disabled selected>Выберите город</option>
                        <#list cityList as city>
                            <option value="${city.getId()}">${city.getCity()}</option>
                        </#list>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Тип</td>
                <td>
                    <select name="typeOfLocation" id="typeOfLocation" class="select-field" onchange="checkUniversity(this)">
                        <option disabled selected>Выберите тип</option>
                        <#list typeList as type>
                            <option value="${type.getId()}">${type.getType()}</option>
                        </#list>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Адрес</td>
                <td><input type="text" id="address" name="address"</td>
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
                <td>Цена аренды</td>
                <td><input type="text" id="rentCoast" name="rentCoast"</td>
            </tr>
            <tr>
                <td>Цена за 1 лист</td>
                <td><input type="text" id="coastForPrint" name="coastForPrint"</td>
            </tr>
            <input type="submit" value="Добавить">
        </table>
    </form>
</@c.page>
