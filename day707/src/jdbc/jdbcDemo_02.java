package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo_02 {
    public static void main(String[] args) throws SQLException {
        insert();
    }

    private static void insert() throws SQLException {
        //获取连接
        Connection con = jdbcUtil.getConnection();
        //获取可执行对象
        Statement st = con.createStatement();
        //执行并获取结果
        System.out.println(st.executeUpdate("insert into student1 values(4,'吴亦凡','男')") > 0 ? "添加成功" : "添加失败");
        //释放资源
        jdbcUtil.closeResource(null,st,con);
    }
}
