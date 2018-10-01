package com.hngd.util;

import com.hngd.data.bean.Bill;
import com.hngd.data.bean.Supplier;
import com.hngd.data.bean.User;
import com.hngd.web.supermarket.service.IBillService;
import com.hngd.web.supermarket.service.ISupplierService;
import com.hngd.web.supermarket.service.impl.BillServiceImpl;
import com.hngd.web.supermarket.service.impl.SupplierServiceImpl;
import com.hngd.web.supermarket.service.impl.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormatUtil {
    static public List<HashMap<String,String>> userToHashMap(List<User> userList){
        List<HashMap<String,String>> list = new ArrayList<>();
        for(User user:userList){
            HashMap<String,String> userMap = new HashMap<>();
            userMap.put("user_id",new String().valueOf(user.getUser_id()));
            userMap.put("user_name",user.getUser_name());
            userMap.put("gender",user.getGender());
            userMap.put("birthday",user.getBirthday());
            userMap.put("phone",user.getPhone_num());
            userMap.put("post",user.getPost());
            list.add(userMap);
        }
        return list;
    }

    static public List<HashMap<String,String>> supplierToHashMap(List<Supplier> suppliersList){
        List<HashMap<String,String>> list = new ArrayList();
        for(Supplier supplier:suppliersList){
            HashMap<String,String> supplierMap = new HashMap();
            supplierMap.put("supplier_id",new String().valueOf(supplier.getSupplier_id()));
            supplierMap.put("supplier_name",supplier.getSupplier_name());
            supplierMap.put("contact_person",supplier.getContact_person());
            supplierMap.put("phone_num",new String().valueOf(supplier.getPhone_num()));
            supplierMap.put("fax",supplier.getFax());
            supplierMap.put("create_time",supplier.getCreate_time());
            list.add(supplierMap);
        }
        return list;
    }

    static public List<HashMap<String,String>> billToHashMap(List<Bill> billList){
        List<HashMap<String,String>> list = new ArrayList();
        for(Bill bill:billList){
            HashMap<String,String> billMap = new HashMap();
            billMap.put("serial_number",new String().valueOf(bill.getSerial_number()));
            billMap.put("good_name",bill.getGood_name());
            billMap.put("supplier",bill.getSupplier());
            billMap.put("bill_amount",new String().valueOf(bill.getBill_amount()));
            billMap.put("payment_status",bill.getPayment_status());
            billMap.put("create_time",bill.getCreate_time());
            list.add(billMap);
        }
        return list;
    }

    static public User paramToUserById(HttpServletRequest request){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findUserById(id);

        request.setAttribute("id", id);
        return user;
    }

    static public User paramToUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("userId"));
        String name = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("data");
        String telephone = request.getParameter("userphone");
        String address = request.getParameter("userAddress");
        String user_type = request.getParameter("userlei");

        User user = new User();
        user.setUser_id(id);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setUser_name(name);
        user.setGender(gender);
        user.setPhone_num(telephone);
        user.setPost(user_type);
        return user;
    }

    static public User noIdParamToUser(HttpServletRequest request) {
        String name = request.getParameter("userName");
        String sex = request.getParameter("gender");
        String birthday = request.getParameter("data");
        String telephone = request.getParameter("userphone");
        String address = request.getParameter("userAddress");
        String user_type = request.getParameter("userlei");

        User user = new User();
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setUser_name(name);
        user.setGender(sex);
        user.setPhone_num(telephone);
        user.setPost(user_type);
        return user;
    }

    static public Bill paramToBills (HttpServletRequest request){
        String serial_num = request.getParameter("serial_number");
        String good_name = request.getParameter("good_name");
        String good_unit = request.getParameter("good_unit");
        String goodNum = request.getParameter("good_num");
        String price = request.getParameter("bill_amount");
        String supplier = request.getParameter("supplier");
        String pay_status = request.getParameter("payment_status");

        Bill bill = new Bill();
        bill.setSerial_number(Integer.parseInt(serial_num));
        bill.setGood_name(good_name);
        bill.setGood_unit(good_unit);
        bill.setGood_num(Integer.parseInt(goodNum));
        bill.setPayment_status(pay_status);
        bill.setSupplier(supplier);
        bill.setBill_amount(price);

        return bill;
    }

    static public Bill paramToBillById (HttpServletRequest req){
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        IBillService billService = new BillServiceImpl();
        Bill bill = billService.findBillById(id);

        req.setAttribute("id", id);
        return bill;
    }

    public static Supplier paramToSupplier(HttpServletRequest req) {
        String idStr = req.getParameter("supplier_id");
        String name = req.getParameter("supplier_name");
        String contact_person = req.getParameter("contact_person");
        String phone_num = req.getParameter("phone_num");
        String address = req.getParameter("address");
        String fax = req.getParameter("fax");
        String description = req.getParameter("description");

        Supplier supplier = new Supplier();
        supplier.setSupplier_id(Integer.parseInt(idStr));
        supplier.setAddress(address);
        supplier.setSupplier_name(name);
        supplier.setPhone_num(phone_num);
        supplier.setDescription(description);
        supplier.setFax(fax);
        supplier.setContact_person(contact_person);
        return supplier;
    }

    public static Supplier paramToSupplierById(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        ISupplierService supplierService = new SupplierServiceImpl();
        Supplier supplier = supplierService.findSupplierById(id);
        request.setAttribute("id", id);
        return supplier;
    }
}
