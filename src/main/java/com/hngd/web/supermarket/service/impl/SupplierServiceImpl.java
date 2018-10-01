package com.hngd.web.supermarket.service.impl;

import com.hngd.data.bean.Supplier;
import com.hngd.data.dao.ISupplierDao;
import com.hngd.data.dao.SupplierDaoImpl;
import com.hngd.util.FormatUtil;
import com.hngd.web.supermarket.service.ISupplierService;

import java.util.HashMap;
import java.util.List;

public class SupplierServiceImpl implements ISupplierService {

    ISupplierDao supplierDao =new SupplierDaoImpl();
    /**
     * 根据Id查找相关供应商信息
     * @param id	指定id
     * @return	Supplier对象
     */
    public Supplier findSupplierById(int id) {
        return supplierDao.findSupplierById(id);
    }

    /**
     * 根据用户名进行供应商信息模糊查询
     * @param name	指定供应商名称
     * @return	list对象
     */
    public List<HashMap<String,String>> findSupplierByName(String name) {
        return FormatUtil.supplierToHashMap(supplierDao.findSupplierByName(name));
    }

    /**
     * 查找所有供应商信息
     * @return 所有供应商信息
     */
    public List<HashMap<String, String>> findAllSupplier() {
        return FormatUtil.supplierToHashMap(supplierDao.findAllSupplier());
    }

    /**
     * 添加供应商
     * @param supplier Supplier对象
     * @return	返回插入结果，成功true，失败false
     */
    public boolean insertSupplier(Supplier supplier) {
        return supplierDao.insertSupplier(supplier);
    }

    /**
     * 修改供应商信息
     * @param supplier	Supplier对象
     * @return 修改结果，成功则true，失败则false
     */
    public boolean updateSupplier(Supplier supplier) {
        return supplierDao.updateSupplier(supplier);
    }

    /**
     * 根据id删除指定供应商
     * @param id
     * @return 删除结果。成功true，失败false。
     */
    public boolean delSupplierById(int id) {
        return supplierDao.delSupplierById(id);
    }


    public int findIdByName(String name) {
        return supplierDao.findIdByName(name);
    }
}
