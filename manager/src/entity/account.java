package entity;

public class account {
    private int id;
    private String cname;
    private int money;
    private String paytype;
    private String createtime;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public account() {
    }

    public account(int id, String cname, int money, String paytype, String createtime, String description) {
        this.id = id;
        this.cname = cname;
        this.money = money;
        this.paytype = paytype;
        this.createtime = createtime;
        this.description = description;
    }
}
