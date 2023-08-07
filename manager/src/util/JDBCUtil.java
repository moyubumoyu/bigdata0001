package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    //1.定义成员变量 DataSource
    private static DataSource ds ;
    static{
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return  ds;
    }

    /*
       获取Connection连接
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
