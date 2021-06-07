    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>PrintDocCloud</title>
    </head>
    <body>
        <br>
        <h2 style="margin-left: 10px">Восстановить пароль</h2>
        <form method="post" action="/getResetPassword">
            <table cellpadding="5 px" style="margin-left: 10px">
                <tr>
                    <td>Введите логин</td>
                    <td>
                        <#if renewPasswordError??>
                            <input type="text" id="login" name="login" class="form-control is-invalid">
                            <label style="color: red">${renewPasswordError}</label>
                        <#else>
                            <input type="text" id="login" name="login">
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" class="btn btn-primary" value="Отправить новый пароль"></td>
                    <td><button type="button" onclick="window.location.href = '/login';">Авторизация</button></td>
                </tr>
            </table>
        </form>
    </body>
    </html>
