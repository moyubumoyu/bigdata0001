package kaoshi.entity;

public class Book {
    private int id;
    private String bookName;
    private String bookAuther;
    private int price;

    public Book(int id, String bookName, String bookAuther, int price) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuther = bookAuther;
        this.price = price;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
