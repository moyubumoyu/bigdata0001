package day0712.service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import day0712.dao.StudentDao;
import day0712.dao.impl.StudentDaoImpl;
import day0712.entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentService {
    static StudentDao dao = new StudentDaoImpl();

    public static void main(String[] args) {
        FindAll();
    }

    public static void FindAll(){
        List<Student> list = dao.findAll();
        list.forEach(System.out::println);

    }

    public static void Insert(){
        Student stu = new Student(222,"阿古茄",656,"男","地球",3);
        int row = dao.addStudent(stu);
        if(row>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
