package com.hngd.web.supermarket.controller;

import com.hngd.data.bean.User;
import com.hngd.web.supermarket.service.IUserService;
import com.hngd.web.supermarket.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    String action = null;
    User user = null;
    IUserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getParameter("action");


        if ("out".equals(action)) {
            req.getSession(false).removeAttribute("currentUser");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        action = req.getParameter("action");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("in".equals(action)) {
            user = userService.findLgInfoByName(username);
            if (user != null) {
                if (user.getPasscode().equals(password) && user.getPost().equals("管理员")) {
                    user.setUser_name(username);
                    req.getSession().setAttribute("currentUser", user);
                    resp.sendRedirect("indexs.jsp");
                } else {
                    req.setAttribute("result", "密码错误！");
                    req.setAttribute("username", username);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("result", "用户名不存在！");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }


    }

}
