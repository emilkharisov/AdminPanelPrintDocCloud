<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
    <meta name="description" content="Описание страницы" />
</head>
<body>
    <#if error??>
        <script>
            alert("Некорректые данные, введите ещё раз")
        </script>
    </#if>

    <form method="post" action="/login">
        <table>
            <tr>
                <td>Логин</td>
                <td><input class="input-field" id="login" name="login"</td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td> <input class="input-field" type="password" id="password" name="password"</td>
            </tr>

            <label for="remember-me">
                <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
            </label>

            <input type="submit" value="Войти">

        </table>
    </form>
</body>
</html>