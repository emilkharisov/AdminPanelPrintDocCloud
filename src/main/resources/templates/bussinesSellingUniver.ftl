<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        var now = new Date().toLocaleString('en-GB', { hour12: false });

        var reportTime = '';

        <#if yearMonth??>
        reportTime = '${yearMonth}';
        </#if>

        <#if year??>
        reportTime = '${year}';
        </#if>

        var titleName = 'Отчёт по бизнес-центрам ' + reportTime;

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
<form method="post" action="/bussinessReportSelling">
    <table cellpadding="3 px">
        <tr>
            <td><label>Выбрать год</label></td>
            <td>
                <select name="year" id="year" class="select-field">
                    <option disabled selected>Выберите год</option>
                    <option value="2021">2021</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label>Выбрать месяц</label></td>
            <td>
                <select name="month" id="month" class="select-field">
                    <option disabled selected>Выберите месяц</option>
                    <option value="1">Январь</option>
                    <option value="2">Февраль</option>
                    <option value="3">Март</option>
                    <option value="4">Апрель</option>
                    <option value="5">Май</option>
                    <option value="6">Июнь</option>
                    <option value="7">Июль</option>
                    <option value="8">Август</option>
                    <option value="9">Сентябрь</option>
                    <option value="10">Октябрь</option>
                    <option value="11">Ноябрь</option>
                    <option value="12">Декабрь</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" class="btn btn-primary" value="Поиск"></td>
        </tr>
    </table>
</form>

    <br>
    <table id="table1" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Локация</th>
            <th>Город</th>
            <th>Адресс</th>
            <th>Дата и время</th>
            <th>Сумма</th>
            <th>Количество страниц</th>
        </tr>
        </thead>
        <tbody>
        <#list sellings as selling>
        <tr>
            <td>${selling.getVendingMachine().getName()}</td>
            <td>${selling.getVendingMachine().getCity().getCity()}</td>
            <td>${selling.getVendingMachine().getAddress()}</td>
            <td>${selling.getTime()}</td>
            <td>${selling.getSum()}</td>
            <td>${selling.getCountOfPaper()}</td>
        </tr>
        </#list>
        </tbody>

    </table>
</@c.page>
