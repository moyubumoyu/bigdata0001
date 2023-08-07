package kaoshi.main;

import kaoshi.entity.Book;
import kaoshi.service.impl.BookServiceImpl;

import java.util.Scanner;

public class BookManger {
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("************图书管理系统**************");
            System.out.println("1.添加图书 2.查询图书 3.删除图书 4.修改图书 5.查询所有书籍 0.退出");

            int num = sc.nextInt();

            switch (num){
                case 1:
                    System.out.println("输入要添加的图书id:");
                    int id1 = sc.nextInt();
                    System.out.println("输入要添加的图书名：");
                    String name1 = sc.next();
                    System.out.println("输入要添加的图书作者：");
                    String auther1 = sc.next();
                    System.out.println("输入要添加的图书价格：");
                    int price1 = sc.nextInt();

                    Book book = new Book(id1,name1,auther1,price1);
                    bookService.addBook(book);
                    break;
                case 2:
                    System.out.println("输入要查询的图书id:");
                    int id2 = sc.nextInt();
                    bookService.selectBook(id2);
                    break;
                case 3:
                    System.out.println("输入要删除的图书id:");
                    int id3 = sc.nextInt();
                    bookService.deleteBook(id3);
                    break;
                case 4:
                    System.out.println("输入要修改的图书id:");
                    int id4 = sc.nextInt();
                    bookService.modifyBook(id4);
                    break;
                case 5:
                    bookService.selectAll();
                    break;
                case 0:
                    return;
            }
        }
    }
}
