package com.hngd.web.supermarket.service;

import com.hngd.data.bean.Bill;

import java.util.HashMap;
import java.util.List;

public interface IBillService {
    //根据Id查询订单
    Bill findBillById(int id);

    //查询所有订单信息
    List<HashMap<String, String>> findAllBill();

    List<HashMap<String,String>> findBillByCondition(Bill bill);

    //添加订单
    boolean insertBill(Bill bill);

    //修改订单信息
    boolean updateBillById(Bill bill);

    //删除订单
    boolean delBillById(int id);
}
