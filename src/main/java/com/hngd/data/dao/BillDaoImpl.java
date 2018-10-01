package com.hngd.data.dao;

import com.hngd.data.bean.Bill;
import com.hngd.data.mapper.BillMapper;
import com.hngd.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BillDaoImpl implements IBillDao {
    SqlSession sqlSession = null;
    BillMapper mapper = null;

    private void init() {
        sqlSession = MyBatisHelper.getSession();
        mapper = sqlSession.getMapper(BillMapper.class);
    }

    @Override
    public Bill findBillById(int id) {
        init();
        Bill bill = mapper.findBillById(id);
        sqlSession.close();
        return bill;
    }

    @Override
    public List<Bill> findAllBill() {
        init();
        List<Bill> list = mapper.findAllBill();
        sqlSession.close();
        return list;
    }

    @Override
    public boolean insertBill(Bill bill) {
        init();
        boolean result = mapper.insertBill(bill);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public boolean updateBillById(Bill bill) {
        init();
        boolean result = mapper.updateBillById(bill);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public List<Bill> findBillByCondition(Bill bill) {
        init();
        List<Bill> billList = mapper.findBillByCondition(bill);
        return billList;
    }

    @Override
    public boolean delBillById(int id) {
        init();
        boolean result = mapper.delBillById(id);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

}
