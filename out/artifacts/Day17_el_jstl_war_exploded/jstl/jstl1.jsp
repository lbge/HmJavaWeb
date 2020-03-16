<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<c:if test="true">
    <h1>
        true
    </h1>
</c:if>
<br>

<%
    List list = new ArrayList();
    list.add("aaa");
    request.setAttribute("list", list);

    request.setAttribute("num", 3);
%>

<c:if test="${not empty list}">
    遍历集合。。。
</c:if>
<br>

<c:if test="${num % 2 == 0}">
    偶数
</c:if>

<c:if test="${num % 2 != 0}">
    奇数
</c:if>


</body>
</html>
