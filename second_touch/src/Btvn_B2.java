import java.util.Scanner;

class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private String publishDate;

    //constructor
    Book(String a,String b,String c,String d,String e)
    {
        this.id = a;
        this.title = b;
        this.author = c;
        this.category = d;
        this.publishDate = e;
    }
    //getter
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getPublishDate() { return publishDate; }
    //setter
    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
    @Override
    public String toString() {
        return "" +
                "|" + id +
                "|" + title + '|' +
                "|" + author + '|' +
                "|" + category + '|' +
                "|" + publishDate + '|' +
                "\n---/";
    }
}

class Library{
    private Book[] Lib;
    private int size;
    private int pointer;
    //constructor/setter
    Library(int size)
    {
        this.size = size;
        this.Lib = new Book[size];
        this.pointer = -1;
    }
    void displayBooks()
    {
        for(Book b:Lib)
        {
            if(b!=null)
            System.out.println(b);
        }
    }
    boolean addBook(Book book)
    {
        if(pointer >= size || book == null)
            return false;
        pointer+=1;
        Lib[pointer] = book;
        return true;
    }
    boolean fixBook(String Id, Book fixedone) {
        for (int i = 0; i <= size; i++) {
            if (Lib[i] != null && Lib[i].getId().equals(Id)) {
                Lib[i].setTitle(fixedone.getTitle());
                Lib[i].setAuthor(fixedone.getAuthor());
                Lib[i].setCategory(fixedone.getCategory());
                Lib[i].setPublishDate(fixedone.getPublishDate());
                return true;
            }
        }
        return false;
    }
    boolean delete(String Id){
        for (int i = 0; i <= size; i++) {
            if (Lib[i] != null && Lib[i].getId().equals(Id)) {
                Lib[i].setTitle("");
                Lib[i].setAuthor("");
                Lib[i].setCategory("");
                Lib[i].setPublishDate("");
                Lib[i].setId("");
                return true;
            }
        }
        return false;
    }

}
class admin{
    private String name = "Nayn";
    private String password = "thecat";
    admin(String name,String password){
        this.name = name;
        this.password = password;
    }
    //getter
    String getName()
    {
        return name;
    }
    String getPass()
    {
        return password;
    }
    //setter
    void setPass(String newP)
    {
        this.password = newP;
    }
}

public class Btvn_B2 {
    private static Scanner sc = new Scanner(System.in);

    public static Book inputBook() {
        System.out.print("Nhap ID: ");
        String id = sc.nextLine().trim();

        System.out.print("Nhap tieu de: ");
        String title = sc.nextLine().trim();

        System.out.print("Nhap tac gia: ");
        String author = sc.nextLine().trim();

        System.out.print("Nhap the loai: ");
        String category = sc.nextLine().trim();

        System.out.print("Nhap ngay phat hanh: ");
        String publishDate = sc.nextLine().trim();

        // Dong goi du lieu thanh doi tuong Book roi tra ve
        return new Book(id, title, author, category, publishDate);
    }

    // 2. KHU VỰC ĐIỀU HƯỚNG VÀ XUẤT (MENU CHÍNH)
    public static void main(String[] args) {
        Library myLib = new Library(100);

        while (true) {
            System.out.println("\n--- QUAN LY THU VIEN ---");
            System.out.println("1. Them sach");
            System.out.println("2. Sua thong tin sach");
            System.out.println("3. Hien thi danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Book newBook = inputBook();
                    if (myLib.addBook(newBook)) {
                        System.out.println(">> Them sach thanh cong!");
                    } else {
                        System.out.println(">> Them sach that bai!");
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID sach can sua: ");
                    String id = sc.nextLine().trim();
                    System.out.println("Nhap thong tin moi:");
                    Book updatedInfo = inputBook();

                    if (myLib.fixBook(id, updatedInfo)) {
                        System.out.println(">> Cap nhat thanh cong!");
                    } else {
                        System.out.println(">> Khong tim thay sach!");
                    }
                    break;

                case 3:
                    myLib.displayBooks();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    return;

                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}
