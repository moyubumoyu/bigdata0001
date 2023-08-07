package jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class DatasourceDemo {
    public static void main(String[] args) throws Exception {
        HashMap<String,String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("D:/idea/work/web1/day707/src/druid.properties"));

        String len;

        while((len=br.readLine())!=null){
            String[] arr = len.split("=");
            map.put(arr[0],arr[1]);
        }
        br.close();

        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);

        Connection con = dataSource.getConnection();
        String sql = "update account set money=? where name=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,5000);
        ps.setString(2,"商家");

        System.out.println(ps.executeUpdate()>0 ? "成功":"失败");
        ps.close();

    }
}
