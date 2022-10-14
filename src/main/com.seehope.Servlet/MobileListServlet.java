package com.seehope.Servlet;

import com.seehope.dao.MobileDao;
import com.seehope.entity.Mobile;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.seehope.entity
 * @Author XSH
 * @Date 2022-09-19 19:35
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet(name = "MobileListServlet", value = "/list")
public class MobileListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //打印流
        PrintWriter out = response.getWriter();
        //展示手机信息列表
        Map<String, Mobile> mobileMap = MobileDao.findAllMobiles();
        for (Mobile mobile : mobileMap.values()) {
            out.write("<a href='mobileDetail?id=" + mobile.getId() + "'target='_blank'>" + mobile.getBrand() + "</a><br/>");
        }


        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            out.write("你最近浏览下面的书：<br/>");
        }
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("ids")) {
                String ids = cookies[i].getValue(); //"3-2-1"
                String[] str = ids.split("-");
                for (String id : str) {
                    Mobile mobile = MobileDao.findById(id);
                    out.write(mobile.getBrand() + "<br/>");
                }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
