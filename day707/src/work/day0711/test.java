package work.day0711;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);
    static QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    public static void main(String[] args) throws SQLException {

        insert();
        //login();
    }
    private static void insert() throws SQLException {

        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        String sql = "insert into user(username,password) values(?,?)";

        System.out.println(qr.update(sql,username,password)>0 ? "添加成功":"添加失败");
    }
    private static void login() throws SQLException {

        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        String sql = "select * from user where username=?";
        //获取数据库中的信息
        Map<String,Object> map = qr.query(sql,new MapHandler(),username);
        //若用户名为空，则用户名错误
        try{
            String username0 = String.valueOf(map.get("username"));
        } catch (Exception e) {
            System.out.println("用户名错误");
            return;
        }
        String password0 = String.valueOf(map.get("password"));

        if(password0.equals(password)){
            System.out.println("登录成功");
        }

    }
}
