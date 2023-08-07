package work.day0710;

import jdbc.jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入此次的消费金额");
        double money = sc.nextDouble();
        //转账方法
        account(money);
    }
    private static void account(double money){
        //获取连接
        Connection con = jdbcUtil.getConnection();
        //获取可执行对象
        PreparedStatement ps = null;

        try{
            con.setAutoCommit(false);
            //顾客转账
            ps = con.prepareStatement("update account set money = money+? where name=?");
            ps.setDouble(1,-money);
            ps.setString(2,"顾客");
            System.out.println(ps.executeUpdate()>0 ? "修改成功":"修改失败");
            //商家收钱
            //ps = con.prepareStatement("update account set money = money+? where name='商家'");
            ps.setDouble(1,money);
            ps.setString(2,"商家");
            System.out.println(ps.executeUpdate()>0 ? "修改成功":"修改失败");

            con.commit();

        }catch (Exception throwables){
            try{
                con.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            {
                jdbcUtil.closeResource(null,ps,con);
            }
        }
    }
}
