package com.hngd.web.supermarket.service.impl;

import com.hngd.data.bean.Bill;
import com.hngd.data.dao.BillDaoImpl;
import com.hngd.data.dao.IBillDao;
import com.hngd.util.FormatUtil;
import com.hngd.web.supermarket.service.IBillService;

import java.util.HashMap;
import java.util.List;

public class BillServiceImpl implements IBillService {
    IBillDao billDao = new BillDaoImpl();
    @Override
    public Bill findBillById(int id) {
        return billDao.findBillById(id);
    }

    @Override
    public List<HashMap<String, String>> findAllBill() {
        return FormatUtil.billToHashMap(billDao.findAllBill());
    }

    @Override
    public boolean insertBill(Bill bill) {
        return billDao.insertBill(bill);
    }

    @Override
    public boolean updateBillById(Bill bill) {
        return billDao.updateBillById(bill);
    }

    @Override
    public List<HashMap<String, String>> findBillByCondition(Bill bill) {
         return FormatUtil.billToHashMap(billDao.findBillByCondition(bill));
    }

    @Override
    public boolean delBillById(int id) {
        return billDao.delBillById(id);
    }
}
