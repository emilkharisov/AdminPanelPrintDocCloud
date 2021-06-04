<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        var now = new Date().toLocaleString('en-GB', { hour12: false });
        var titleName = 'Выгрузка аппаратов за ' + now

        $(document).ready(function() {
            $('#table1').DataTable( {
                dom: 'Bfrtip',
                buttons: [
                    {
                        extend: 'excel',
                        text: 'Excel',
                        title: titleName
                    },
                    {
                        extend: 'pdf',
                        text: 'PDF',
                        title: titleName
                    },
                    {
                        extend: 'print',
                        text: 'Печать',
                        title: titleName
                    },
                    {
                        extend: 'copy',
                        text: 'Copy',
                        title: titleName
                    }
                ]
            } );
        } );

    </script>

    <br>
    <table id="table1" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Город</th>
            <th>Локация</th>
            <th>Адрес</th>
            <th>Аренда</th>
            <th>Цена за лист</th>
        </tr>
        </thead>
        <tbody>
        <#list vendingList as vending>
        <tr>
            <td>${vending.getName()}</td>
            <td>${vending.getCity().getCity()}</td>
            <td>${vending.getTypeOfLocation().getType()}</td>
            <td>${vending.getAddress()}</td>
            <td>${vending.getRentCoast()}</td>
            <td>${vending.getCoastForPrint()}</td>

        </tr>
        </#list>
        </tbody>

    </table>
</@c.page>
