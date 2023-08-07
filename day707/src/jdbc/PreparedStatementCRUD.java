package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementCRUD {
    public static void main(String[] args) throws SQLException {
        /*selectAll();
        update();
        delete();*/
        insert();
    }
    private static void selectAll() throws SQLException {
        //获取连接
        Connection con = jdbcUtil.getConnection();
        //获取可执行对象
        PreparedStatement ps = con.prepareStatement("select * from user");
        //执行并获取结果
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            System.out.println(id+"\t"+username+"\t"+password);

        }
        //释放资源
        jdbcUtil.closeResource(rs,ps,con);
    }
    private static void update() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("update user set username=?,password=? where id=?");
        //设置值
        ps.setString(1,"悟空");
        ps.setString(2,"111");
        ps.setInt(3,2);
        //执行并获取结果
        System.out.println(ps.executeUpdate()>0 ? "修改成功":"修改失败");

        jdbcUtil.closeResource(null,ps,con);
    }
    private static void delete() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("delete from user where id=?");

        ps.setInt(1,3);
        System.out.println(ps.executeUpdate()>0 ? "删除成功":"删除失败");

        jdbcUtil.closeResource(null,ps,con);
    }
    private static void insert() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?)");

        ps.setInt(1,4);
        ps.setString(2,"八戒");
        ps.setString(3,"222");

        System.out.println(ps.executeUpdate()>0 ? "添加成功":"添加失败");

        jdbcUtil.closeResource(null,ps,con);
    }


}
