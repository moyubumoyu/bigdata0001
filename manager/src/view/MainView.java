package view;

import entity.User;
import entity.account;
import service.UserService;
import service.accountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView {
    UserService userService = new UserService();
    accountService ac = new accountService();

    Scanner sc = new Scanner(System.in);
    public void UserView(){
        while (true){
            System.out.println("*********用户管理系统**********");
            System.out.println("请输入你的操作 1：登录 2：注册 3：修改 4：删除 5：查询 任意键退出");

            String n =sc.nextLine();
            switch (n){
                case "1":
                    login();
                    break;
                case "2":
                    userService.insertUser();
                    break;
                case "3":
                    userService.updateUser();
                    break;
                case "4":
                    userService.deleteUser();
                    break;
                case "5":
                    userService.queryAll();
                    break;
                default:
                    System.out.println("bye bye");
                    System.exit(0);
                    break;
            }
        }
    }

    private void login(){
        User u = userService.login();
        if(u==null){
            System.out.println("用户名或密码错误，请重新登录");
        }else {
            System.out.println("登录成功");
            zwManagerView();
        }
    }

    public void zwManagerView(){
        while(true){
            System.out.println("*************账务管理系统**************");
            System.out.println("请输入你要进行的操作 1:添加账务 2:编辑账务 3:删除账务 4:查询账务  任意键退出");

            String n = sc.nextLine();
            switch (n){
                case "1":
                    insert();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    query();
                    break;
                default:
                    System.out.println("bye bye");
                    System.exit(0);
                    break;
            }

        }
    }
    private void update(){
        System.out.println("输入要修改的账务id:");
        String id = sc.nextLine();
        System.out.println("修改的分类名称：");
        String cname = sc.nextLine();
        System.out.println("修改的金额：");
        String money = sc.nextLine();
        System.out.println("修改的支出类型：");
        String paytype = sc.nextLine();
        System.out.println("修改的日期：");
        String createtime = sc.nextLine();
        System.out.println("修改的账务描述：");
        String description = sc.nextLine();

        account a = new account();
        a.setId(Integer.parseInt(id));
        a.setCname(cname);
        a.setMoney(Integer.parseInt(money));
        a.setPaytype(paytype);
        a.setCreatetime(createtime);
        a.setDescription(description);

        int a0 = ac.updateAccount(a);
        if(a0>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
    private void query(){
        System.out.println("1:查询所有 2:按条件查询");
        int chose = sc.nextInt();
        switch (chose){
            case 1:
                ac.queryAll();
                break;
            case 2:
                System.out.println("输入要查询的支出类型:");
                String paytype = sc.nextLine();
                System.out.println("输入要查询的时间：");
                String createtime = sc.nextLine();
                List<account> accounts = ac.queryByTwo(paytype,createtime);
                accounts.forEach(System.out::println);
            default:
                break;
        }
    }
    private void insert(){
        while(true){
            System.out.println("请输入要插入的账务信息");
            System.out.println("分类名称：");
            String cname = sc.nextLine();
            System.out.println("金额：");
            String money = sc.nextLine();
            System.out.println("支出类型：");
            String paytype = sc.nextLine();
            System.out.println("创建日期：");
            String createtime = sc.nextLine();
            System.out.println("账务描述：");
            String description = sc.nextLine();

            account a = new account();
            a.setCname(cname);
            a.setMoney(Integer.parseInt(money));
            a.setPaytype(paytype);
            a.setCreatetime(createtime);
            a.setDescription(description);
            int a0 = ac.insertAccount(a);
            if(a0>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
                break;
            }

            System.out.println("是否继续添加Y/N");
            String s = sc.nextLine();
            if("Y".equals(s)){

            } else {
                break;
            }

        }
    }
    private void delete(){
        ArrayList<String> ids = new ArrayList<>();
        while(true){
            System.out.println("输入要删除的编号    输入0停止");
            String num = sc.nextLine();
            try{
                //查询id是否存在
                int a = ac.queryById(Integer.parseInt(num)).getId();
            }catch (Exception e){
                System.out.println("该编号不存在");
                break;
            }
            if(num.equals("0")){
                break;
            }else {
                ids.add(num);
            }
        }
        int row = ac.deleteAccount(ids);
        System.out.println("共删除"+row+"行");
    }
}
