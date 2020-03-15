<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)) {
                flag = true;
                String value = cookie.getValue();
                System.out.println("解码前:"+value);
                String valueDe = URLDecoder.decode(value, "utf-8");
                System.out.println("解码后"+valueDe);
                out.write("<h1>欢迎回来，您上次访问的时间是：" + valueDe + "</h1>");


                String strDate = sdf.format(date);
                System.out.println("编码前："+strDate);
                //URL编码
                String strDateEn = URLEncoder.encode(strDate, "utf-8");
                System.out.println("编码后："+strDateEn);
                cookie.setValue(strDateEn);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                break;
            }
        }
    }

    if (cookies == null || cookies.length == 0 || !flag) {



        String strDate = sdf.format(date);
        System.out.println("编码前："+strDate);
        //URL编码
        String strDateEn = URLEncoder.encode(strDate, "utf-8");
        System.out.println("编码后："+strDateEn);
        Cookie cookie = new Cookie("lastTime",strDateEn);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
        out.write("<h1>欢迎首次访问 </h1>");
    }
%>
</body>
</html>
