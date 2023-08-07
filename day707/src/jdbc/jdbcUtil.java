package jdbc;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

public class jdbcUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        /*ResourceBundle db = ResourceBundle.getBundle("db");
        driver = db.getString("jdbc.driver");
        url = db.getString("jdbc.url");
        username = db.getString("jdbc.username");
        password = db.getString("jdbc.password");*/

        /*try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("D:/idea/work/web1/day707/src/db.properties"));
            String len;
            HashMap<String, String> map = new HashMap<>();
            while ((len = br.readLine()) != null) {
                String arr[] = len.split("=");
                map.put(arr[0], arr[1]);
            }
            driver = map.get("jdbc.driver");
            url = map.get("jdbc.url");
            username = map.get("jdbc.username");
            password = map.get("jdbc.password");
        }catch (Exception e){
            e.printStackTrace();
        }*/

        InputStream fis = jdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        try {
            pro.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = pro.getProperty("jdbc.driver");
        url = pro.getProperty("jdbc.url");
        username = pro.getProperty("jdbc.username");
        password = pro.getProperty("jdbc.password");
    }
    public  static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeResource(ResultSet rs, Statement st,Connection con){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(getConnection());
    }

}
