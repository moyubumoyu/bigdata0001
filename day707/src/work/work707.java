package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class work707 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*insetD("大大","男");
        insetD("小小","女");
        insetD("多多","女");
        modifyD(2);*/
        selectD();
    }
    public static void insetD(String a,String b) throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/

        String sql = "insert into `student1`(`name1`,`sex1`) values( ? , ? )";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, a );
        preparedStatement.setString(2, b );

        int row = preparedStatement.executeUpdate();

        System.out.println(row > 0 ? "添加成功" : "添加失败");
/*
        /*4、释放资源*/

        con.close();
        preparedStatement.close();
    }
    public static void modifyD(int id) throws ClassNotFoundException, SQLException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/

        String sql = "update `student1` set `name1`='猪八戒' where `id` = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id );

        int row = preparedStatement.executeUpdate();

        System.out.println(row > 0 ? "修改成功" : "修改失败");
/*
        /*4、释放资源*/

        con.close();
        preparedStatement.close();
    }
    public static void selectD() throws SQLException, ClassNotFoundException {
        /*1、注册驱动*/
        Class.forName("com.mysql.cj.jdbc.Driver");
        /*2、获取连接?characterEncoding=utf-8&useSSL=false*/
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        /*3、获取可执行对象*/

        String sql = "select * from student1";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        List<Student> list = new ArrayList<>();

        while(rs.next()){
            int id = rs.getInt("id");
            String name1 = rs.getString("name1");
            String sex1 = rs.getString("sex1");

            Student student = new Student(id,name1,sex1);
            list.add(student);
        }
        for(Student s:list){
            System.out.println("id:"+s.getId()+" name1:"+s.getName1()+" sex1:"+s.getSex1());
        }
        /*4、释放资源*/
        con.close();
        preparedStatement.close();


    }
}
