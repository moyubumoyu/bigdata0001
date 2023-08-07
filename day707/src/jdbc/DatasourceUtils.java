package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatasourceUtils {
    static DataSource dataSource;


    static {
        //给连接池进行赋值
        try {
            Properties pro = new Properties();
            pro.load(DatasourceUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 返回连接池
     * */

    public static DataSource getDataSource() {

        return dataSource;
    }
    /*
     * 返回连接对象
     * */

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
