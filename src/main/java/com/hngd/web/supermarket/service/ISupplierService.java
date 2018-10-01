package com.hngd.web.supermarket.service;

import com.hngd.data.bean.Supplier;

import java.util.HashMap;
import java.util.List;

public interface ISupplierService {
    Supplier findSupplierById(int id);

    List<HashMap<String,String>> findSupplierByName(String name);

    List<HashMap<String,String>> findAllSupplier();

    int findIdByName(String name);

    boolean insertSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean delSupplierById(int id);

}
