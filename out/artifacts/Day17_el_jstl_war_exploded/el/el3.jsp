<%@ page import="com.xducs.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = new User();
    user.setName("zhangsan");
    user.setAge(23);
    user.setBirthday(new Date());

    request.setAttribute("user", user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("name","刘亦菲");
    map.put("location","China");
    map.put("user",user);
    map.put("list",list);
    request.setAttribute("map",map);
%>
<h3>获取对象中的值</h3>
${requestScope.user}<br>
${requestScope.user.name}<br>
${requestScope.user.age}<br>
${requestScope.user.birthday}<br>
${requestScope.user.birthday.month}<br>
${user.birStr}
<h3>获取list集合中的元素</h3>
${list}<br>
${list[1]}<br>
${list[11]}<br>
${list[2].birStr}<br>
<h3>获取map集合中的元素</h3>
${map.name}<br>
${map["location"]}<br>
${map.user.name}<br>
${map.list[2].birStr}<br>
</body>
</html>
