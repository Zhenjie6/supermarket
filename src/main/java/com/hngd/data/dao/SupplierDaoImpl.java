package com.hngd.data.dao;

import com.hngd.data.bean.Supplier;
import com.hngd.data.mapper.SupplierMapper;
import com.hngd.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SupplierDaoImpl implements ISupplierDao {

    SqlSession sqlSession = null;
    SupplierMapper mapper = null;

    private void init(){
        sqlSession = MyBatisHelper.getSession();
        mapper = sqlSession.getMapper(SupplierMapper.class);
    }
    /**
     * 根据Id查找相关供应商信息
     * @param id	指定id
     * @return	Supplier对象
     */
    public Supplier findSupplierById(int id) {
        init();
        Supplier supplier = mapper.findSupplierById(id);
        sqlSession.close();
        return supplier;
    }

    /**
     * 根据用户名进行供应商信息模糊查询
     * @param name	指定用户名
     * @return	list对象
     */
    public List<Supplier> findSupplierByName(String name) {
        init();
        List<Supplier> list = mapper.findSupplierByName("%" + name + "%");
        sqlSession.close();
        return list;
    }

    /**
     * 查找所有供应商信息
     * @return 所有供应商信息
     */
    public List<Supplier> findAllSupplier() {
        init();
        List<Supplier> list = mapper.findAllSupplier();
        sqlSession.close();
        return list;
    }

    /**
     * 添加供应商
     * @param supplier Supplier对象
     * @return	返回插入结果，成功true，失败false
     */
    public boolean insertSupplier(Supplier supplier) {
        init();
        boolean result = mapper.insertSupplier(supplier);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    /**
     * 修改供应商信息
     * @param supplier	Supplier对象
     * @return 修改结果，成功则true，失败则false
     */
    public boolean updateSupplier(Supplier supplier) {
        init();
        boolean result = mapper.updateSupplierById(supplier);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    /**
     * 根据id删除指定供应商
     * @param id
     * @return 删除结果。成功true，失败false。
     */
    public boolean delSupplierById(int id) {
        init();
        boolean result = mapper.delSupplierById(id);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public int findIdByName(String name) {
        init();
        int id = mapper.findIdByName(name);
        sqlSession.close();
        return id;
    }
}
