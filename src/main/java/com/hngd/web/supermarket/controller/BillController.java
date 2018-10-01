package com.hngd.web.supermarket.controller;

import com.hngd.data.bean.Bill;
import com.hngd.data.bean.Supplier;
import com.hngd.data.dao.SupplierDaoImpl;
import com.hngd.util.FormatUtil;
import com.hngd.web.supermarket.service.IBillService;
import com.hngd.web.supermarket.service.impl.BillServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = "/bill")
public class BillController extends HttpServlet {

    IBillService billService = new BillServiceImpl();
    Bill bill = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dissableCache(req,resp);
        String action = req.getParameter("action");
        if(req.getSession().getAttribute("currentUser")==null){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        if("list".equals(action)){
            lsit(req,resp);
        }else if("add".equals(action)){
            add(req,resp);
        }else if("view".equals(action)){
            view(req,resp);
        }else if("update".equals(action)){
            update(req,resp);
        }else if("delete".equals(action)){
            delete(req,resp);
        }else if("findBillByCondition".equals(action)){
            findBillByCondition(req,resp);
        }
    }
    private void findBillByCondition(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String good_name = req.getParameter("good_name");
        String supplier_name = req.getParameter("supplier_name");
        String payment_status = req.getParameter("payment_status");
        bill = new Bill();
        bill.setGood_name(good_name);
        bill.setSupplier(supplier_name);
        bill.setPayment_status(payment_status);
        List<HashMap<String,String>> list = billService.findBillByCondition(bill);
        req.setAttribute("list",list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/billList.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void delete(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String idStr = req.getParameter("id");
        billService.delBillById(Integer.parseInt(idStr));
        req.getRequestDispatcher("billList.jsp").forward(req, resp);
    }

    private void view(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        bill = FormatUtil.paramToBillById(req);

        req.setAttribute("bill", bill);
        req.getRequestDispatcher("billView.jsp").forward(req, resp);
    }

    private void lsit(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        IBillService billService = new BillServiceImpl();
        List<HashMap<String,String>> list = billService.findAllBill();
        req.setAttribute("list",list);
        List<Supplier> supplierList = new SupplierDaoImpl().findAllSupplier();
        req.setAttribute("supplierList", supplierList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/billList.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void add(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        List<Supplier> list = new SupplierDaoImpl().findAllSupplier();
        req.setAttribute("list", list);
        req.getRequestDispatcher("billAdd.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
        bill = FormatUtil.paramToBillById(req);
//        List<Supplier> list = new SupplierDaoImpl().findAllSupplier();
//
//        req.setAttribute("list", list);
        req.setAttribute("bill", bill);
        req.getRequestDispatcher("billUpdate.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
         bill = FormatUtil.paramToBills(req);

        if("billAdd".equals(action)){

            billService.insertBill(bill);
            resp.sendRedirect("/bill?action=list");
        }if ("billUpdate".equals(action)){
            billService.updateBillById(bill);
            resp.sendRedirect("/bill?action=list");
        }
    }

    public void dissableCache(HttpServletRequest req,HttpServletResponse resp){
        resp.setHeader("Cache-Control","no-store");
        resp.setDateHeader("Expires",0);
        resp.setHeader("Pragm","no-cache");
    }
}
