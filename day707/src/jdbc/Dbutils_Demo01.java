package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class Dbutils_Demo01 {
    static QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    public static void main(String[] args) throws SQLException {
        delete();
    }

    private static void delete() throws SQLException {
        String sql = "delete from user where id=?";
        System.out.println(qr.update(sql,2)>0 ? "删除成功":"删除失败");
    }
    private static void insert() throws SQLException {
        String sql = "insert into user values(?,?,?)";
        System.out.println(qr.update(sql,3,"比克","963")>0 ? "添加成功":"添加失败");
    }
    private static void update() throws SQLException {
        //执行sql
        String sql = "update user set password =? where id =?";
        Object arr[] = {"333", 1};
        System.out.println(qr.update(sql, arr) > 0 ? "更新成功" : "更新失败");
    }


}
