package com.hngd.web.supermarket.controller;


import com.hngd.data.bean.User;
import com.hngd.util.FormatUtil;
import com.hngd.web.supermarket.service.IUserService;
import com.hngd.web.supermarket.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {
    User tempUser = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dissableCache(req, resp);
        String action = req.getParameter("action");

        if(req.getSession().getAttribute("currentUser")==null){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        if ("update".equals(action)) {
            tempUser = update(req, resp);
        } else if ("list".equals(action)) {
            list(req, resp);
        } else if ("view".equals(action)) {
            view(req, resp);
        } else if ("delete".equals(action)) {
            delete(req, resp);
        } else if ("findUserByName".equals(action)) {
            findUserByName(req, resp);
        }
    }

    private void findUserByName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        List<HashMap<String, String>> theList = FormatUtil.userToHashMap(new UserServiceImpl().findUserByName(name));
        req.setAttribute("list", theList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userList.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = FormatUtil.paramToUserById(req);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/userView.jsp").forward(req, resp);
    }


    public User update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = new FormatUtil().paramToUserById(req);

        req.setAttribute("user", user);
        req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        return user;
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService iUserService = new UserServiceImpl();
        List<HashMap<String, String>> theList = iUserService.getUserList();
        req.setAttribute("list", theList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userList.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idStr = req.getParameter("id");
        new UserServiceImpl().delUserById(Integer.parseInt(idStr));
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }

    private void dissableCache(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Cache-Control", "no-store");
        resp.setDateHeader("Expires", 0);
        resp.setHeader("Pragm", "no-cache");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        req.setCharacterEncoding("UTF-8");
        if ("userAdd".equals(action)) {
            User user = FormatUtil.paramToUser(req);
            String userpassword = req.getParameter("userpassword");
            String userRemi = req.getParameter("userRemi");
            if (userpassword.equals(userRemi)) {
                user.setPasscode(userpassword);
                new UserServiceImpl().insertUser(user);
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userList.jsp");
//                requestDispatcher.forward(req, resp);
                resp.sendRedirect("/user?action=list");
            }
        } else if ("userUpdate".equals(action)) {
            User user1 = FormatUtil.noIdParamToUser(req);
            String id = req.getParameter("id");
            user1.setUser_id(Integer.parseInt(id));
            new UserServiceImpl().updateUser(user1);
            resp.sendRedirect("/user?action=list");
        } else if ("pwdUpdate".equals(action)) {
            User user = (User) req.getSession(false).getAttribute("currentUser");
            String oldPassword = req.getParameter("oldPassword");
            String newPassword = req.getParameter("newPassword");
            String reNewPassword = req.getParameter("reNewPassword");

            if (oldPassword.equals(user.getPasscode())) {
                if (newPassword.equals(reNewPassword)) {
                    user.setPasscode(newPassword);
                    new UserServiceImpl().updatePwdById(user);
                    req.getSession(false).removeAttribute("currentUser");
                    req.setAttribute("reLogin", "密码已失效，请重新登录！");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else {
                    req.setAttribute("doesnotMatch", "两次密码不一致！");
                    req.getRequestDispatcher("password.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("falsePwd", "旧密码错误！");
                req.getRequestDispatcher("password.jsp").forward(req, resp);
            }
        }
    }
}
