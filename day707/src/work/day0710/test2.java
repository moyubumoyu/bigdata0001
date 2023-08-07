package work.day0710;

import jdbc.jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test2 {
    public static void main(String[] args) throws SQLException {
        //selectAll();
        //update();
        //delete();
        insert();
    }

    private static void selectAll() throws SQLException {
        //获取连接
        Connection con = jdbcUtil.getConnection();
        //获取可执行对象
        PreparedStatement ps = con.prepareStatement("select * from student");
        //执行并获取结果
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            int score = rs.getInt(4);
            System.out.println(id+"\t"+name+"\t"+email+"\t"+score);

        }
        //释放资源
        jdbcUtil.closeResource(rs,ps,con);
    }
    private static void update() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("update student set name=?,email=?,score=? where id=?");
        //设置值
        ps.setString(1,"孙悟饭");
        ps.setString(2,"111@qq.com");
        ps.setInt(3,100);
        ps.setInt(4,1);
        //执行并获取结果
        System.out.println(ps.executeUpdate()>0 ? "修改成功":"修改失败");

        jdbcUtil.closeResource(null,ps,con);
    }
    private static void delete() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("delete from student where id=?");

        ps.setInt(1,3);
        System.out.println(ps.executeUpdate()>0 ? "删除成功":"删除失败");

        jdbcUtil.closeResource(null,ps,con);
    }
    private static void insert() throws SQLException {
        Connection con = jdbcUtil.getConnection();

        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");

        ps.setInt(1,4);
        ps.setString(2,"比克");
        ps.setString(3,"456@qq.com");
        ps.setInt(4,80);

        System.out.println(ps.executeUpdate()>0 ? "添加成功":"添加失败");

        jdbcUtil.closeResource(null,ps,con);
    }
}
