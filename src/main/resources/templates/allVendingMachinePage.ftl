<#import "parts/common.ftl" as c>
<title>Привет</title>
<@c.page>
    <script>
        $(document).ready(function() {
            $('#table1').DataTable( {
                dom: 'Bfrtip',
                buttons: [
                    {
                        extend: 'excel',
                        text: 'Excel',
                        title: 'Выгрузка'
                    },
                    {
                        extend: 'pdf',
                        text: 'PDF',
                        title: 'Выгрузка'
                    },
                    {
                        extend: 'print',
                        text: 'Печать',
                        title: 'Выгрузка'
                    },
                    {
                        extend: 'copy',
                        text: 'Copy',
                        title: 'Выгрузка'
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
            <th>Адресс</th>
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
