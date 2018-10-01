package com.hngd.data.dao;

import com.hngd.data.bean.Supplier;

import java.util.HashMap;
import java.util.List;

public interface ISupplierDao {
    Supplier findSupplierById(int id);

    List<Supplier> findSupplierByName(String name);

    List<Supplier> findAllSupplier();

    int findIdByName(String name);

    boolean insertSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean delSupplierById(int id);
}
