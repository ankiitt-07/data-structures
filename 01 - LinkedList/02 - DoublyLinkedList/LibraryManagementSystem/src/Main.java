public class Main {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();
        library.addBookAtEnd("The Great", "Jerry", "Novel", 101, true);
        library.addBookAtBeginning("1984", "Ankit", "Dystopian", 102, true);
        library.addBookAtPosition("The Hero", "Shadow", "Adventure", 103, true, 2);
        library.displayBooks();
        library.updateAvailability(102, false);
        library.displayBooksReverse();
        System.out.println("Total Books: " + library.countBooks());
        library.searchBook("1984", "");
        library.removeBookByID(101);
        library.displayBooks();
    }
}