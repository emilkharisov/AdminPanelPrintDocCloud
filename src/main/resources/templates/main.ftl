<#import "parts/common.ftl" as c>
<@c.page>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .carousel{
            background: #2f4357;
            margin-top: 20px;
        }
        .carousel-item{
            text-align: center;
            min-height: 280px; /* Prevent carousel from being distorted if for some reason image doesn't load */
        }
    </style>
    <br>
    <table cellpadding="10 px" id="table1">
        <tr>
            <td>
                <div class="card text-white bg-primary mb-3" style="width: 15rem; height: 7rem">
                    <div class="card-body">
                        <h5 class="card-title">1000 ₽</h5>
                        <p class="card-text">Продажи за день</p>
                    </div>
                </div>
            </td>
            <td>
                <div class="card text-white bg-success mb-3" style="width: 15rem; height: 7rem">
                    <div class="card-body">
                        <h5 class="card-title">25000 ₽</h5>
                        <p class="card-text">Продажи за месяц</p>
                    </div>
                </div>
            </td>
            <td>
                <div class="card text-white bg-danger mb-3" style="width: 15rem; height: 7rem">
                    <div class="card-body">
                        <h5 class="card-title">500000 ₽</h5>
                        <p class="card-text">Продажи за год</p>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <#if isAdmin??>
        <div class="container-lg my-3" id="adminPage">
            <div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
                <!-- Carousel indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                </ol>
                <!-- Wrapper for carousel items -->
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <button type="button" class="btn btn-success" onclick="window.location.href = '/getAddUserPage';" style="padding: 40px 40px; font-size: 30px; margin-top: 20px;">Добавить</button>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Добавить пользователя</h5>
                            <p>@PrintDocCloud Admin</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <button type="button" onclick="window.location.href = '/addVendingMachine';" class="btn btn-success" style="padding: 40px 40px; font-size: 30px; margin-top: 20px;">Добавить</button>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Добавить вендинговый аппарат</h5>
                            <p>@PrintDocCloud Admin</p>
                        </div>
                    </div>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#myCarousel" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>
        </div>
    </#if>
</@c.page>