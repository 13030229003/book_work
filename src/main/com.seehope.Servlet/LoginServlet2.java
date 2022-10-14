package com.seehope.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PACKAGE_NAME: com.seehope.entity
 * @Author XSH
 * @Date 2022-09-19 20:15
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet(name = "LoginServlet2", value = "/login2")
public class LoginServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {

                    String value2 = URLDecoder.decode(cookie.getValue(), "UTF-8");//cookie使用utf-8编码
                    response.getWriter().println("欢迎回来，您上次访问的时间为：" + value2);

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
                    return;
                }

            }
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
        response.getWriter().println("您好，欢迎首次登录！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
