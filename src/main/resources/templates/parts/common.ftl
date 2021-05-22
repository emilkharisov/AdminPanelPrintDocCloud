<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PrintDocCloud</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous" color="white">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.7.0/css/buttons.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>

    <script src="https://cdn.datatables.net/buttons/1.7.0/js/dataTables.buttons.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.0/js/buttons.print.min.js"></script>

</head>
<body>
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="img/PrintDocCloud.png" height="80px" width="80px"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <a class="navbar-brand" href="#" style="font-size: 35px">Мониторинг</a>
            <a class="navbar-brand" href="#" style="font-size: 35px"></a>
            <li class="nav-item">
                <a class="nav-link" href="/getMainPage" style="font-size: 20px">Панель управления</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/getReportMain" style="font-size: 20px">Отчёты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/getVendingMain" style="font-size: 20px">Аппараты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/editMainPage" style="font-size: 20px">Редактирование</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#" style="font-size: 18px">${login}</a>
        <a class="nav-link" href="/logout" style="font-size: 18px">Выйти</a>
    </div>
</nav>
<!-- NAVBAR -->
<#nested>
</body>
</html>
</#macro>