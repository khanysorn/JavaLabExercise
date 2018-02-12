package self.model;

public class BookCatalog {

    private Book[] books;
    private int numOfBooks;

    public BookCatalog(int lengthOfCatalog) {
        this.books = new Book[lengthOfCatalog];     // ใช้ this reference
    }

    public int size() {
        return books.length;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int addBook(Book bookAdded) {
        int value=0;
        for (int i = 0; i < books.length; i++) {        //วนทุกช่องของ Array
            if (books[i] == null) {                     //ถ้าช่องตำแหน่ง i ไม่มีหนังสือ
                books[i] = bookAdded;                   //เอาหนังสือที่รับเข้ามาไปวางตำแหน่ง i
                numOfBooks++;                           //นับจำนวนหนังสือ +1;
                value=i; break;                         //Return ค่าช่องที่มีหนังสือ และออกจาก Loop
            }else{
                value=-1;                               //ถ้าช่องนั้นมีหนังสือ ให้ค่าเป็น -1
            }
        }
        return value;
    }

    public int unAvailableBook(Book bookUnAvailable) {
        int value=0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(bookUnAvailable)==true) {   //ถ้าช่องตำแหน่ง i เป็นหนังสือเล่มเดียวกับ bookUnAvailable
                books[i] = null;                            //ให้ช่องนั้นเป็นว่าง (เอาหนังสือออก)    
                numOfBooks--;                               //ลบจำนวนหนังสือออก
                value=i; break;                             //บอกว่าเล่มที่เอาออกอยู่ตำแหน่งไหน
            }else{
                value=-1;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        String listOfBooks = "***List of Books***\n";
        for (int i = 0; i < numOfBooks; i++) {
            listOfBooks += books[i] + "\n";
        }

        return listOfBooks;
    }

}
