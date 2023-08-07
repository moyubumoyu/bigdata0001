package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("老弟请输入此次的消费金额");
        double money = sc.nextDouble();
        //转账方法
        account(money);
    }
    private static void account(double money){

        Connection con = jdbcUtil.getConnection();

        Statement st = null;

        try{
            con.setAutoCommit(false);
            st = con.createStatement();

            System.out.println(st.executeUpdate("update account set money=money+"+money+" where name='八戒'"));
            System.out.println(st.executeUpdate("update account set money=money-"+money+" where name='悟空'"));

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
                jdbcUtil.closeResource(null,st,con);
            }
        }
    }

}
