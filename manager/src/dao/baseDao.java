package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

public class baseDao<T> {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    public int insertT(String sql,Object...obj){
        try {
            return qr.update(sql,obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int deleteT(String sql,Object...obj){
        try {
            return qr.update(sql,obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateT(String sql,Object[] obj){
        try {
            return qr.update(sql,obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<T> findAll(String sql, Class claz){
        try {
            return qr.query(sql,new BeanListHandler<T>(claz));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public T findOne(String sql,Class claz,Object...obj){
        try {
            return qr.query(sql,new BeanHandler<T>(claz),obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<T> findTwo(String sql,Class claz,Object[] obj){
        try {
            return qr.query(sql,new BeanListHandler<T>(claz),obj);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
