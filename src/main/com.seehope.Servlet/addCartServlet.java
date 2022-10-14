package com.seehope.Servlet;

import com.seehope.entity.Mobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.seehope.Servlet
 * @Author XSH
 * @Date 2022-09-19 19:35
 * @Version 1.0.0
 * @Description：
 **/
@WebServlet("/addCart")
public class addCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;Charset=utf-8");
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Map<String, Integer> cartMap = (Map<String, Integer>)session.getAttribute("cart");
        if (cartMap == null) {
            cartMap = new HashMap<>();
        }


        if (cartMap.containsKey(id)) {
            int num = cartMap.get(id);
            cartMap.put(id,num + 1);
        }else {
            cartMap.put(id,1);
        }
        session.setAttribute("cart",cartMap);
        response.getWriter().write("<script>alert('加入购物车成功！');location.href='allMobile'</script>");


    }
}
