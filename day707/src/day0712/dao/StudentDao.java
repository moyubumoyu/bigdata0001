package day0712.dao;

import day0712.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    int addStudent(Student student);
    int editStudent(Student student);
    int deleteStudent(Student student);
}
