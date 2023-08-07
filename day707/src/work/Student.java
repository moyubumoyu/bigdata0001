package work;

public class Student {
    private int id;
    private String name1;
    private String sex1;

    public Student() {
    }

    public Student(int id, String name1, String sex1) {
        this.id = id;
        this.name1 = name1;
        this.sex1 = sex1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getSex1() {
        return sex1;
    }

    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }
}
