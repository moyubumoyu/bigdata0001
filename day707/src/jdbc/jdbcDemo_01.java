package jdbc;

import java.sql.*;

/*
 *   需求向users表中添加一条记录
 *
 *   1、注册驱动
 *   2、获取连接
 *   3、获取可执行对象
 *   4、执行并获取结果
 *   5、释放资源*
 * */
public class jdbcDemo_01 {

    public static void main(String[] args) throws Exception {
        selectD();

    }

    public static void insetD() throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/
        Statement st = con.createStatement();
        /*4、执行并获取结果*/
        String sql ="insert into student (id,name,email,score) values(111,'123456','123456@qq.com',22) ";
        int row = st.executeUpdate(sql);

        System.out.println(row > 0 ? "添加成功" : "添加失败");
/*        if (row > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }*/
        /*5、释放资源*/
        st.close();
        con.close();

    }
    public static void deleteD() throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/
        Statement st = con.createStatement();

        System.out.println(st.executeUpdate("delete from student where id=111") > 0? "删除成功" : "删除失败");
        st.close();
        con.close();

    }
    public static void updateD() throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/
        Statement st = con.createStatement();

        System.out.println(st.executeUpdate("update student set score = 100 where id = 1") > 0? "修改成功" : "修改失败");
        st.close();
        con.close();
    }
    public static void selectD() throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from student");
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            int score = rs.getInt("score");
            System.out.println("id:"+id+" name:"+name+" email:"+email+" score:"+score);

        }
        st.close();
        con.close();
    }

}