<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>


<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
request.setAttribute("ls",list);
%>

<c:forEach begin="1" end="10" var="i" step="2">
    ${i}<br>
</c:forEach>
<hr>

<c:forEach items="${ls}" var="str" varStatus="i">
    ${i.index} ${i.count} ${str} <br>
</c:forEach>
</body>
</html>
