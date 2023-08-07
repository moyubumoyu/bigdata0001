package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JDBCUtil;

import java.sql.SQLException;

public class UserDao extends baseDao<User>{

    /*QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
    public User findUserByUserNameAndPassWord(String username, String password){
        String sql = "select * from user where usercname=? and password=?";

        try {
            return qr.query(sql,new BeanHandler<User>(User.class),username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }*/

}
