package service;

import dao.UserDao;
import entity.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);
    private UserDao dao = new UserDao();
    public User login() {
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        String sql = "select * from user where username=? and password=?";
        ArrayList<Object> list = new ArrayList<>();
        list.add(username);
        list.add(password);
        return  dao.findOne(sql,User.class,list.toArray());
    }


    public void queryAll(){
        String sql = "select * from user";
        List<User> list = dao.findAll(sql, User.class);
        for(User i: list){
            System.out.println(i.getUid()+"\t"+i.getUsername()+"\t"+i.getPassword());
        }
    }
   /* public void queryOne(){
        System.out.println("输入要查询的用户uid:");
        int id = sc.nextInt();

        String sql = "select * from user where id=?";
        User u = dao.findOne(sql,User.class,);
        System.out.println(u.getUid()+"\t"+u.getUsername()+"\t"+u.getPassword());
    }*/
    public void insertUser(){
        System.out.println("请输入要注册的用户信息");
        System.out.println("uid:");
        int uid = sc.nextInt();
        System.out.println("用户名：");
        String username = sc.next();
        System.out.println("密码：");
        String password = sc.next();

        String sql = "insert into account values(?,?,?)";
        int a = dao.insertT(sql,uid,username,password);
        if(a>0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
    public void deleteUser(){
        System.out.println("输入要删除的用户uid:");
        int uid = sc.nextInt();

        String sql = "delete from user where uid=?";
        int a = dao.deleteT(sql,uid);
        if(a>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
    public void updateUser(){
        ArrayList<Object> list = new ArrayList<>();
        System.out.println("输入要修改的用户id:");
        int uid = sc.nextInt();
        System.out.println("用户名：");
        String username = sc.next();
        list.add(username);
        System.out.println("密码：");
        String password = sc.next();
        list.add(password);
        list.add(uid);
        String sql = "update user set username=?,password=? where uid=?";
        int a = dao.updateT(sql,list.toArray());
        if(a>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
