package com.hngd.data.mapper;

import com.hngd.data.bean.Bill;

import java.util.List;

public interface BillMapper {
    //根据Id查询订单
    Bill findBillById(int id);

    //查询所有订单信息
    List<Bill> findAllBill();

    //添加订单
    boolean insertBill(Bill bill);

    //修改订单信息
    boolean updateBillById(Bill bill);

    //删除订单
    boolean delBillById(int id);

    List<Bill> findBillByCondition(Bill bill);
}
