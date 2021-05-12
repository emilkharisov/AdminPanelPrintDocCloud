<#import "parts/common.ftl" as c>
<@c.page>
    <script>
        $(document).ready(function() {
            $('#table1').DataTable();
        } );
    </script>

    <table id="table1" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Position</th>
            <th>Office</th>
        </tr>
        </thead>
        <tbody>
        <#list vendingList as vending>
        <tr>
            <td>${vending.getId()}</td>
            <td>${vending.getName()}</td>
            <td>${vending.getCity().getCity()}</td>
        </tr>
        </#list>
        </tbody>

    </table>
</@c.page>
