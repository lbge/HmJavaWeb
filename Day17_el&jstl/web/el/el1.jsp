<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
\${ 3 >4 }
<br>
${ 13 >4 }
<hr>

<h3>算数运算符</h3>
${3 + 4}<br>
${3 / 4}<br>
${3 div 4} <br>
${3 % 4} <br>
${3 mod 4} <br>

<h3>比较运算符</h3>
${5 == 6}

<h3>逻辑运算符</h3>
<h4>empty运算符</h4>
<%
    String str = "";
    request.setAttribute("str", str);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    request.setAttribute("list",list);

    List list1 = new ArrayList();
    request.setAttribute("list1",list1);
%>
${str}<br>
${empty str}<br>
${!empty list}<br>
${empty list1}<br>


</body>
</html>
