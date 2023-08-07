package service;
import entity.account;
import dao.accountDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class accountService {
    Scanner sc = new Scanner(System.in);
    private accountDao dao = new accountDao();
    public void queryAll(){
        String sql = "select * from account";
        List<account> list = dao.findAll(sql, account.class);

        for(account i: list){
            System.out.println(i.getId()+"\t"+i.getCname()+"\t"+i.getMoney()+"\t"+i.getPaytype()+"\t"+i.getCreatetime()+"\t"+i.getDescription());
        }
    }
    public List<account> queryByTwo(String paytype,String createtime){

        ArrayList<Object> list = new ArrayList<>();
        String sql = "select * from account where 1=1";
        if(!"".equals(paytype)){
            sql=sql+" and paytype=? ";
            list.add(paytype);
        }
        if(!"".equals(createtime)){
            sql=sql+" and createtime=? ";
            list.add(createtime);
        }

        List<account> accounts = dao.findTwo(sql,account.class,list.toArray());

        return accounts;
    }
    public account queryById(int id){
        String sql = "select * from account where id=?";
        account account = dao.findOne(sql, account.class,id);
        return account;
    }
    public int insertAccount(account account){

        String sql = "insert into account values(?,?,?,?,?,?)";
        int a = dao.insertT(sql,null,account.getCname(),account.getMoney(),account.getPaytype(),account.getCreatetime(),account.getDescription());
        return a;

    }
    public int deleteAccount(ArrayList<String> ids){
        String sql = "delete from account where id=?";
        int index = 0;
        for(String id:ids){
            int row = dao.deleteT(sql,id);
            if(row>0){
                index++;
            }
        }
        return index;
    }
    public int updateAccount(account a){


        ArrayList<Object> list = new ArrayList<>();
        String sql = "update account set";
        if(!"".equals(a.getCname())){
            sql+=" cname=?, ";
            list.add(a.getCname());
        }
        if(a.getMoney()!=0){
            sql+=" money=?, ";
            list.add(a.getMoney());
        }
        if(!"".equals(a.getPaytype())){
            sql+=" paytype=?, ";
            list.add(a.getPaytype());
        }
        if(!"".equals(a.getCreatetime())){
            sql+=" creatime=?, ";
            list.add(a.getCreatetime());
        }
        if(!"".equals(a.getDescription())){
            sql+=" description=? ";
            list.add(a.getDescription());
        }
        sql=sql.substring(0,sql.lastIndexOf(","));
        sql+=" where id=?";
        list.add(a.getId());

        return dao.updateT(sql,list.toArray());

    }
}
