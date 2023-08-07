package kaoshi.service.impl;

import kaoshi.entity.Book;
import kaoshi.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    Scanner sc = new Scanner(System.in);
    List<Book> BookList = new ArrayList<>();
    Book book0 = new Book();
    @Override
    public void addBook(Book book) {
        for(Book o:BookList){
            if(o.getId()==book.getId()){
                System.out.println("添加失败，该编号书籍已存在");
                return;
            }
        }
        BookList.add(book);
        System.out.println("添加成功");
    }

    @Override
    public void selectBook(int id) {
        int a = 0;
        for(Book o:BookList){
            if(o.getId()==id){
                System.out.println("书籍名："+o.getBookName()+" 作者："+o.getBookAuther()+" 价格："+o.getPrice());
                return;
            }
        }
        if(a==0){
            System.out.println("未查询到该书籍");
        }
    }

    @Override
    public void deleteBook(int id) {
        int a = 0;
        for(Book o:BookList){
            if(o.getId()==id){
                BookList.remove(o);
                System.out.println("删除成功");
                return;
            }
        }
        if(a==0){
            System.out.println("未查询到该书籍");
        }
    }

    @Override
    public void modifyBook(int id) {
        int a = 0;
        for(int i=0;i<BookList.size();i++){
            book0 = BookList.get(i);
            if(book0.getId()==id){
                System.out.println("输入要修改的图书价格：");
                int price0 = sc.nextInt();
                book0.setPrice(price0);
                BookList.set(i,book0);
                System.out.println("修改后的图书信息：");
                System.out.println("图书id:"+book0.getId()+" 图书名："+book0.getBookName()+"图书价格："+book0.getPrice());
                return;
            }
        }
        if(a==0){
            System.out.println("未查询到该书籍");
        }
    }
    @Override
    public void selectAll(){
        for(Book o:BookList){
            System.out.println("图书id:"+o.getId()+" 图书名："+o.getBookName()+" 图书作者："+o.getBookAuther()+"图书价格："+o.getPrice());
        }
    }

}
