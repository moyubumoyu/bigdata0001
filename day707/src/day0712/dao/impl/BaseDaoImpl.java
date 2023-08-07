package day0712.dao.impl;

import day0712.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T> {
    QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());

    public List<T> findAll(String sql, Class claz, Object...obj){
        try{
            return qr.query(sql,new BeanListHandler<T>(claz),obj);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
    public T findOne(String sql,Class claz,Object...obj){
        try{
            return qr.query(sql,new BeanHandler<T>(claz),obj);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
    public int updateT(String sql,Object...obj){
        try{
            return qr.update(sql,obj);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0;
    }
}
