package day0712.dao;

import day0712.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());

    public List<T> findAll(String sql, Class claz, Object...obj);
    public T findOne(String sql,Class claz,Object...obj);
    public int updateT(String sql,Object...obj);
}
