package com.seehope.Servlet;

import com.seehope.dao.MobileDao;
import com.seehope.entity.Mobile;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.seehope.Servlet
 * @Author XSH
 * @Date 2022-09-19 19:25
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet("/allMobile")
public class ShowAllMobileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;Charset=utf-8");
        PrintWriter out = response.getWriter();

        Map<String, Mobile> mobiles = MobileDao.findAllMobiles();

        out.print("本网站有以下好书:点击即可加入购物车!<br/>");
        out.print("<table border='1'>");
        for (String id : mobiles.keySet()) {
            Mobile mobile = mobiles.get(id);
            out.print("<tr><td>" + mobile.getId() + "</td><td>" + mobile.getBrand()
                    + "</td><td>" + mobile.getPrice() + "</td><td>" + mobile.getType()
                    + "</td><td><a href='addCart?id=" + id + "' target='_blank'>加入购物车</a></td></tr>");
        }
        out.print("</table>");
        out.print("<a href='showCart'>查看购物车</a>");
    }
}
