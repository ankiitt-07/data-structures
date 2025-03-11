import java.util.ArrayList;
import java.util.List;
public class MovieLinkedList {
    private MovieNode head;

    public void addMovie(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
        } else {
            MovieNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
        }
    }

    public void addMovieAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        newNode.setNext(head);
        if (head != null) {
            head.setPrev(newNode);
        }
        head = newNode;
    }

    public void addMovieAtPosition(String movieTitle, String director, int yearOfRelease, double rating, int position) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if (position == 1) {
            addMovieAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        MovieNode temp = head;
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

    public void displayMovies() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println("Movie Title: " + temp.getMovieTitle() + " Director: " + temp.getDirector() +
                    " Year of Release: " + temp.getYear() + " Rating: " + temp.getRating());
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void displayReverse() {
        MovieNode temp = head;
        if (temp == null) return;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        while (temp != null) {
            System.out.println("Movie Title: " + temp.getMovieTitle() + " Director: " + temp.getDirector() +
                    " Year of Release: " + temp.getYear() + " Rating: " + temp.getRating());
            temp = temp.getPrev();
        }
        System.out.println();
    }

    public void searchByDirectorOrRating(String directorName, double rating) {
        List<MovieNode> list = new ArrayList<>();
        MovieNode temp = head;
        while (temp != null) {
            if (temp.getDirector().equals(directorName) || temp.getRating() == rating) {
                list.add(temp);
            }
            temp = temp.getNext();
        }

        if (list.isEmpty()) {
            System.out.println("Movie not found");
            return;
        }

        for (MovieNode movie : list) {
            System.out.println("Movie Title: " + movie.getMovieTitle() + " Director: " + movie.getDirector() +
                    " Year of Release: " + movie.getYear() + " Rating: " + movie.getRating());
        }
    }

    public void removeMovieByTitle(String movieTitle) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovieTitle().equals(movieTitle)) {
                if (temp.getPrev() != null) {
                    temp.getPrev().setNext(temp.getNext());
                } else {
                    head = temp.getNext();
                }

                if (temp.getNext() != null) {
                    temp.getNext().setPrev(temp.getPrev());
                }

                System.out.println("Removed: " + movieTitle);
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Movie not found");
    }

    public void updateRating(String movieTitle, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovieTitle().equals(movieTitle)) {
                temp.setRating(rating);
                System.out.println("Updated rating for " + movieTitle + " to " + rating);
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Movie not found");
    }
}