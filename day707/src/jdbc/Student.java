package jdbc;

public class Student {
     /*
       ctrl+shift+r   批量修改
       alt+shift+insert 批量写入
       ctrl+alt+l  一键格式化
     */

    private String studentid;
    private String studentname;
    private int studentage;
    private String studentsex;
    private String studentaddress;
    private int classid;

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", studentname='" + studentname + '\'' +
                ", studentage=" + studentage +
                ", studentsex='" + studentsex + '\'' +
                ", studentaddress='" + studentaddress + '\'' +
                ", classid=" + classid +
                '}';
    }

    public Student() {
    }

    public Student(String studentid, String studentname, int studentage, String studentsex, String studentaddress, int classid) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentage = studentage;
        this.studentsex = studentsex;
        this.studentaddress = studentaddress;
        this.classid = classid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getStudentage() {
        return studentage;
    }

    public void setStudentage(int studentage) {
        this.studentage = studentage;
    }

    public String getStudentsex() {
        return studentsex;
    }

    public void setStudentsex(String studentsex) {
        this.studentsex = studentsex;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
