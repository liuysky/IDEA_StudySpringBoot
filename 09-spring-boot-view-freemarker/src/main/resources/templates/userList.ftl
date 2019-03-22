<html>
    <head>
        <title>freemarker</title>
        <meta charset="UTF-8"/>
    </head>
    <body>
        <table border="1" align="center" width="50%">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AGE</th>
            </tr>

            <#list list as user>
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.userage}</td>
                </tr>
            </#list>

        </table>
    </body>

</html>