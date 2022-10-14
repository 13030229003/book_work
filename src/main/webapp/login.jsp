<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: han2018
  Date: 2022-09-19
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<%
    boolean bl = false;
    String value2 = null;
    //1.获取所有Cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)) {
                value2 = URLDecoder.decode(cookie.getValue(), "UTF-8");//cookie使用utf-8编码
                bl = true;
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str1 = sdf.format(date);//本次的访问时间
                //编码
                String str2 = URLEncoder.encode(str1);
                //给value重新赋值
                cookie.setValue(str2);
                //设置cookie的存活时间
                cookie.setMaxAge(60 * 60);//
                response.addCookie(cookie);
//                return;
            }

        }
    }
    if (bl) {
        out.print("欢迎回来，您上次访问的时间为：" + value2);
    }
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str1 = sdf.format(date);
    String str2 = URLEncoder.encode(str1);//进行编码
    Cookie cookie = new Cookie("lastTime", str2);
    //设置cookie的存活时间
    cookie.setMaxAge(60 * 60);//
    response.addCookie(cookie);
    //获取Cookie的value,时间
//    System.out.println("您好，欢迎首次登录！");
    if (!bl) {
        out.print("您好，欢迎首次登录！");
    }
%>
</body>
</html>
