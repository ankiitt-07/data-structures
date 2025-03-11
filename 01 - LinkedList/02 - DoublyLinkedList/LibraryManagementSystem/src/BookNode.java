public class BookNode {
    private String bookTitle;
    private String author;
    private String genre;
    private int bookID;
    private boolean isAvailable;
    private BookNode next;
    private BookNode prev;

    public BookNode(String bookTitle, String author, String genre, int bookID, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public BookNode getNext() {
        return next;
    }
    public void setNext(BookNode next) {
        this.next = next;
    }
    public BookNode getPrev() {
        return prev;
    }
    public void setPrev(BookNode prev) {
        this.prev = prev;
    }
}
