<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
<%
    request.setAttribute("name", "zjajsh");
    session.setAttribute("age", "23");
    session.setAttribute("name", "lisi");

%>

<h3>el获取域中的值</h3>

${requestScope.name}
${sessionScope.age}
${sessionScope.hah}

${name}
${sessionScope.name}


</body>
</html>
