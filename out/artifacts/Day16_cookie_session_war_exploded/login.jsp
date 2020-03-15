<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>

        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/Day16/CheckCodeServlet?time=" + new Date().getTime();
            };
        }
    </script>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="/Day16/LoginServlet" method="post">
    <table>
        <tr>
            <td>
                用户名
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                密码
            </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>
                验证码
            </td>
            <td>
                <input type="text" name="checkCode">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <img id="img" src="/Day16/CheckCodeServlet">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>

<div>
    <%=
    request.getAttribute("loginFail") == null ? "" : request.getAttribute("loginFail")%>
</div>
<div>
    <%= request.getAttribute("checkCodeErr") == null ? "" : request.getAttribute("checkCodeErr")%>
</div>
</body>
</html>
