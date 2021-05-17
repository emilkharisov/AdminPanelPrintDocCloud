<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        var now = new Date().toLocaleString('en-GB', { hour12: false });
        var titleName = 'Выгрузка аппаратов за ' + now

        $(document).ready(function() {
            $('#table1').DataTable();
        } );

    </script>

    <br>
    <table id="table1" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Наименование Юр.лица</th>
            <th>Тип Юр.лица</th>
            <th>Логин</th>
            <th>Почта</th>
            <th>Админ</th>
            <th>Статус</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list userList as user>
        <tr>
            <td>${user.getNameOfLegalEntity()}</td>
            <td>${user.getTypeOfLegalEntity()}</td>
            <td>${user.getLogin()}</td>
            <td>${user.getEmail()}</td>
            <#if user.getRole() == roleAdmin>
                <td>Админ</td>
            <#else>
                <td>Пользователь</td>
            </#if>
            <#if user.getState() == stateBanned>
                <td>Заблокирован</td>
            <#else>
                <td>Активный</td>
            </#if>
            <td><a href="/getEditUserPage?userId=${user.getId()}">Редактировать</a></td>
            <#if user.getState() == stateBanned>
                <td><a href="/unBlockUser?userId=${user.getId()}" class="badge badge-success">Раблокировать</a></td>
            <#else>
                <td><a href="/blockUser?userId=${user.getId()}" class="badge badge-danger">Заблокировать</a></td>
            </#if>
        </tr>
        </#list>
        </tbody>

    </table>
</@c.page>
