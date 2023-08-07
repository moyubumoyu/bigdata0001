package day0712.service;

import day0712.dao.AccountDao;
import day0712.dao.impl.AccountDaoImpl;
import day0712.entity.Account;

import java.util.List;

public class AccountService {
    static AccountDaoImpl dao = new AccountDaoImpl();

    public static void main(String[] args) {
        //findAll();
        findOne();
    }
    public static void findAll(){
        String sql = "select * from account";
        List<Account> accounts = dao.findAll(sql,Account.class);
        accounts.forEach(System.out::println);
    }
    public static void findOne(){
        String sql = "select * from account where id=?";
        Account account = dao.findOne(sql, Account.class, 3);
        System.out.println(account.getName());
    }
}
