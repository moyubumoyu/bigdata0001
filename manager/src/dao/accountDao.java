package dao;

import entity.account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import util.JDBCUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class accountDao extends baseDao<account>{
    /*QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
    public int insertAccount(account a){
        String sql = "insert into account where values(?,?,?,?,?,?)";
        try {
            return qr.update(sql,a.getId(),a.getCname(),a.getMoney(),a.getPaytype(),a.getCreatetime(),a.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<account> queryAllAccount(){
        String sql = "select * from account";
        try {
            return qr.query(sql,new BeanListHandler<account>(account.class));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
