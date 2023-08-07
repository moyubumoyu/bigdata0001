package jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dbutils_Demo04 {
    static QueryRunner qr = new QueryRunner(DatasourceUtils.getDataSource());
    public static void main(String[] args) throws SQLException {

        //findAll();
        findOne();

        //findCount();
        //findOneByMap();
        //findAllByMap();
        //findByArray();
        //findByListArray();
        //findClunm();
    }

    private static void findClunm() throws SQLException {

        String sql = "select name from student";

        List<Object> list = qr.query(sql, new ColumnListHandler());

        System.out.println(list);
    }

    private static void findByListArray() throws SQLException {
        String sql = "select * from student";
        List<Object[]> list = qr.query(sql, new ArrayListHandler());
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    private static void findByArray() throws SQLException {

        String sql = "select * from student where id =?";
        Object[] objects = qr.query(sql, new ArrayHandler(), 2);
        System.out.println(Arrays.toString(objects));
    }

    private static void findAllByMap() throws  SQLException {

        String sql = "select * from student";
        List<Map<String, Object>> list = qr.query(sql, new MapListHandler());

        for (Map<String, Object> stringObjectMap : list) {

            Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();

            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey()+"\t"+entry.getValue());
            }
        }
    }

    private static void findOneMap() throws SQLException {
        String sql = "select * from student where id=?";
        Map<String,Object> map = qr.query(sql,new MapHandler(),2);
        Set<Map.Entry<String,Object>> entries = map.entrySet();

        for(Map.Entry<String,Object> entry:entries){
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
    }

    private static void findCount() throws SQLException {
        String sql = "select count(*) from student";
        Object o = qr.query(sql,new ScalarHandler());
        System.out.println(o);
    }
    private static void findOne() throws SQLException {
        String sql = "select * from student where id =?";
        Student student = qr.query(sql, new BeanHandler<Student>(Student.class),2);
        System.out.println(student);
    }

    private static void findAll() throws SQLException {
        String sql = "select * from student ";

        List<Student> studentList = qr.query(sql, new BeanListHandler<Student>(Student.class));

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}
