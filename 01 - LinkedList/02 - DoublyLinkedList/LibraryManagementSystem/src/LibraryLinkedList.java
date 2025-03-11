class LibraryLinkedList {
    private BookNode head;

    public void addBookAtBeginning(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        newNode.setNext(head);
        if (head != null) {
            head.setPrev(newNode);
        }
        head = newNode;
    }

    public void addBookAtEnd(String title, String author, String genre, int id, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (head == null) {
            head = newNode;
            return;
        }
        BookNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        newNode.setPrev(temp);
    }

    public void addBookAtPosition(String title, String author, String genre, int id, boolean available, int position) {
        if (position == 1) {
            addBookAtBeginning(title, author, genre, id, available);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, id, available);
        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        if (temp.getNext() != null) {
            temp.getNext().setPrev(newNode);
        }
        temp.setNext(newNode);
    }

    public void removeBookByID(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.getBookID() == id) {
                if (temp.getPrev() != null) {
                    temp.getPrev().setNext(temp.getNext());
                } else {
                    head = temp.getNext();
                }
                if (temp.getNext() != null) {
                    temp.getNext().setPrev(temp.getPrev());
                }
                System.out.println("Book with ID " + id + " removed.");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Book not found.");
    }

    public void searchBook(String title, String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.getBookTitle().equalsIgnoreCase(title) || temp.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Found: " + temp.getBookTitle() + " by " + temp.getAuthor() + " (Genre: " + temp.getGenre() + ", ID: " + temp.getBookID() + ", Available: " + temp.isAvailable() + ")");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(int id, boolean available) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.getBookID() == id) {
                temp.setAvailability(available);
                System.out.println("Availability updated for Book ID " + id);
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.getBookTitle() + ", Author: " + temp.getAuthor() + ", Genre: " + temp.getGenre() + ", ID: " + temp.getBookID() + ", Available: " + temp.isAvailable());
            temp = temp.getNext();
        }
    }

    public void displayBooksReverse() {
        if (head == null) return;
        BookNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        while (temp != null) {
            System.out.println("Title: " + temp.getBookTitle() + ", Author: " + temp.getAuthor() + ", Genre: " + temp.getGenre() + ", ID: " + temp.getBookID() + ", Available: " + temp.isAvailable());
            temp = temp.getPrev();
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}