<#import "parts/common.ftl" as c>
<link href="/static/css/animationKub.css" rel="stylesheet" type="text/css">
<style>
    .circle {
        list-style: none;
        font-size: 20px;
        line-height: 1.3;
    }
    .disck {
        width: 12px;
        height: 12px;
        float: left;
        margin: 7px 5px 0 5px;
        border-radius: 50%;
        background: radial-gradient(circle, white, red 4px);
    }
    .round {
        border-radius: 100px; /* Радиус скругления */
        border: 3px solid gray; /* Параметры рамки */
        box-shadow: 0 0 7px #666; /* Параметры тени */
    }
</style>
<@c.page>
    <br>

    <div style="margin-left: 20px">
        <#if isAdmin??>
            <h2>Все аппараты</h2>
            <ul class="circle" style="font-size: 30px">
                <hr class="disck"><li><a href="/getAllVendingMachine">Все аппараты</a></li>
                <hr class="disck"><li><a href="/getBooksByYearPage">Аппараты в университетах</a></li>
                <hr class="disck"><li><a href="/getMethodologyByYearPage">Аппараты-бизнес центрах</a></li>
            </ul>
            <br>
        </#if>
        <h2>Аппараты пользователя</h2>
        <ul class="circle" style=font-size: 30px">
            <hr class="disck"><li><a href="/getpatentsByYearPage">Аппараты</a></li>
        </ul>
    </div>
    <div id="wrap" class="wrap">
        <div class="cube">
            <div id="cube" class="cube rotate-y">
                <p class="face back">Print</p>
                <p class="face front">Doc</p>
                <p class="face left">Cloud</p>
                <p class="face rght"></p>
            </div>
        </div>
    </div>

</@c.page>