package com.hngd.web.supermarket.controller;

import com.hngd.data.bean.Supplier;
import com.hngd.util.FormatUtil;
import com.hngd.web.supermarket.service.ISupplierService;
import com.hngd.web.supermarket.service.impl.SupplierServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/supplier")
public class SupplierController extends HttpServlet {
    ISupplierService supplierService = new SupplierServiceImpl();
    Supplier supplier = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dissableCache(req,resp);
        String action = req.getParameter("action");
        if(req.getSession().getAttribute("currentUser")==null){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        if("list".equals(action)){
            list(req,resp);
        }else if("view".equals(action)){
            view(req,resp);
        }else if("update".equals(action)){
            update(req,resp);
        }else if("delete".equals(action)){
            delete(req,resp);
        }else if("findSupplierByName".equals(action)){
            findSupplierByName(req,resp);
        }

    }

    private void findSupplierByName(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String name = req.getParameter("name");
        List<HashMap<String,String>> list;
        list = supplierService.findSupplierByName(name);
        req.setAttribute("list",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/providerList.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void delete(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String idStr = req.getParameter("id");
        supplierService.delSupplierById(Integer.parseInt(idStr));
        req.getRequestDispatcher("providerList.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        supplier = FormatUtil.paramToSupplierById(req);
        req.setAttribute("supplier", supplier);
        req.getRequestDispatcher("providerUpdate.jsp").forward(req, resp);
    }

    private void view(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        supplier = FormatUtil.paramToSupplierById(req);
        req.setAttribute("supplier", supplier);
        req.getRequestDispatcher("providerView.jsp").forward(req, resp);
    }


    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ISupplierService supplierService = new SupplierServiceImpl();
        List<HashMap<String,String>> list = supplierService.findAllSupplier();
        req.setAttribute("list",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/providerList.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String action = req.getParameter("action");
        if("add".equals(action)){
            supplier = FormatUtil.paramToSupplier(req);
            supplierService.insertSupplier(supplier);
            resp.sendRedirect("/supplier?action=list");
        }else if("supplierUpdate".equals(action)){
            supplier = FormatUtil.paramToSupplier(req);
            supplierService.updateSupplier(supplier);
            resp.sendRedirect("/user?action=list");
        }
    }

    private void dissableCache(HttpServletRequest req,HttpServletResponse resp){
        resp.setHeader("Cache-Control","no-store");
        resp.setDateHeader("Expires",0);
        resp.setHeader("Pragm","no-cache");
    }
}
