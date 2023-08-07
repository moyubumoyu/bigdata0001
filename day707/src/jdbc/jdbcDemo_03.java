package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class jdbcDemo_03 {
    public static void main(String[] args) throws Exception {
        //1、获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1?serverTimezone=UTC&", "root", "123456");
        //2、获取可执行对象
        Statement st = con.createStatement();
        //3、执行并获取结果
        ResultSet rs = st.executeQuery("select * from student");
        //创建容器
        ArrayList<Student> list = new ArrayList<>();
        while (rs.next()) {

            String studentId = rs.getString(1);
            String studentName = rs.getString(2);
            int studentAge = rs.getInt(3);
            String studentSex = rs.getString(4);
            String studentAddress = rs.getString(5);
            int classId = rs.getInt(6);
            //封装对象
            Student stu = new Student(studentId, studentName, studentAge, studentSex, studentAddress, classId);
            //添加到集合
            list.add(stu);
        }

        //遍历集合获取对象
        //list.forEach(System.out::println);
        for (Student student : list) {
            System.out.println(student);
        }
        //释放资源
        rs.close();
        st.close();
        con.close();

    }
}
