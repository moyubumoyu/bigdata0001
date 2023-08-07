package day0712.dao.impl;

import day0712.dao.StudentDao;
import day0712.entity.Student;
import day0712.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner qr = new QueryRunner(jdbcUtils.getDataSource());

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        try{
            return qr.query(sql,new BeanListHandler<Student>(Student.class));
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int addStudent(Student student) {
        String sql = "insert into student values(?,?,?,?,?,?)";
        try{
            return qr.update(sql,student.getStudentid(),student.getStudentname(),student.getStudentage(),student.getStudentsex(),student.getStudentaddress(),student.getClassid());
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int editStudent(Student student) {
        String sql = "update student set studentname=?,studentage=?,studentsex=?,studentaddress=?,classid=? where studentid=?";
        try{
            return qr.update(sql,student.getStudentname(),student.getStudentage(),student.getStudentsex(),student.getStudentaddress(),student.getClassid(),student.getStudentid());
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStudent(Student student) {
        String sql = "delete from student where studentid=?";
        try{
            return qr.update(sql,student.getStudentid());
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0;
    }
}
