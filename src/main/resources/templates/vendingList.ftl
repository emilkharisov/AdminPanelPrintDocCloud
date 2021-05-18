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
            <th>Наименование аппарата</th>
            <th>Город</th>
            <th>Тип</th>
            <th>Адресс</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list vendingList as vending>
        <tr>
            <td>${vending.getName()}</td>
            <td>${vending.getCity().getCity()}</td>
            <td>${vending.getTypeOfLocation().getType()}</td>
            <td>${vending.getAddress()}</td>
            <td><a href="/editVendingMachine?machineId=${vending.getId()}">Редактировать</a></td>
        </tr>
        </#list>
        </tbody>

    </table>
</@c.page>
