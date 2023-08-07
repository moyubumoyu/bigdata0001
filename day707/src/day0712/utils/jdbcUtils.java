package day0712.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtils {
    static DataSource dataSource;
    static {
        try{
            Properties pro = new Properties();
            InputStream fis = jdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(fis);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }


}
