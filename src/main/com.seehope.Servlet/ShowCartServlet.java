package com.seehope.Servlet;

import com.seehope.dao.MobileDao;
import com.seehope.entity.Mobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.seehope.Servlet
 * @Author XSH
 * @Date 2022-09-19 19:43
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet("/showCart")
public class ShowCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Map<String, Integer> cartMap = (Map<String, Integer>) session.getAttribute("cart");
        if (cartMap != null) {
            for (String id : cartMap.keySet()) {
                Mobile mobile = MobileDao.findById(id);
                out.write("手机名：" + mobile.getBrand() + ",购买台数：" + cartMap.get(id) + "<br/>");
            }
        } else {
            out.write("你还没有购买商品");
        }
    }
}
