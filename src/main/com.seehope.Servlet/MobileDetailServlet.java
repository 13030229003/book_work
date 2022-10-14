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
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @PACKAGE_NAME: com.seehope.entity
 * @Author XSH
 * @Date 2022-09-19 19:50
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet(name="MobileDetailServlet",value = "/mobileDetail")
public class MobileDetailServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String id =  request.getParameter("id");

        String ids = organizeId(id, request);
        Cookie cookie = new Cookie("ids", ids);
        System.out.println(ids);
        cookie.setMaxAge(60);//设置cook存活时间  60分钟
        response.addCookie(cookie);
        Mobile mobile = MobileDao.findById(id);
        out.write(mobile.toString());

    }
    private String organizeId(String id, HttpServletRequest request) {
        // 得到客户端的Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return id;
        }
        Cookie ids = null;
        for (int i = 0; i < cookies.length; i++) {
            if ("ids".equals(cookies[i].getName())) {
                ids = cookies[i];
            }
        }
        // 如果没有historyBookId的cookie，则还返回id
        if (ids == null) {
            return id;
        }

        String value = ids.getValue();// 4-3-2
        String[] values = value.split("-"); //[4 3 2]
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

        if (list.size() < 3) { //
            if (list.contains(id)) {
                list.remove(id);// 如果包含当前id的值，则删除这个id
            }
        } else {
            if (list.contains(id)) {
                list.remove(id); //[4 2]
            } else {// 说明有3本书的id了
                list.removeLast();// 把最后一个id删除  3 2
            }
        }
        list.addFirst(id);// 最新书的id添加到最前面  [3 4  2 ]

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

}
