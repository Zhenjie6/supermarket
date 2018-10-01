package com.hngd.data.mapper;

import com.hngd.data.bean.Supplier;

import java.util.List;

public interface SupplierMapper {
    //根据用户ID查询信息
    Supplier findSupplierById(int id);

    //根据用户名进行模糊查询
    List<Supplier> findSupplierByName(String name);

    //查询所有用户
    List<Supplier> findAllSupplier();

    //根据名称找id
    int findIdByName(String name);

    //添加用户
    boolean insertSupplier(Supplier supplier);

    //根据Id修改用户信息
    boolean updateSupplierById(Supplier supplier);

    //根据Id删除用户
    boolean delSupplierById(int id);

}
