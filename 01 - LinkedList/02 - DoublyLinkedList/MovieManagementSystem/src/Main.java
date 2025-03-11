public class Main {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding movies to the list
        movieList.addMovie("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovie("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addMovie("Interstellar", "Christopher Nolan", 2014, 8.6);

        System.out.println("All Movies:");
        movieList.displayMovies();

        // Adding a movie at the beginning
        movieList.addMovieAtBeginning("Memento", "Christopher Nolan", 2000, 8.4);
        System.out.println("After adding a movie at the beginning:");
        movieList.displayMovies();

        // Adding a movie at a specific position
        movieList.addMovieAtPosition("Dunkirk", "Christopher Nolan", 2017, 7.9, 3);
        System.out.println("After adding a movie at position 3:");
        movieList.displayMovies();

        // Display movies in reverse order
        System.out.println("Movies in Reverse Order:");
        movieList.displayReverse();

        // Searching movies by director or rating
        System.out.println("Search by Director Christopher Nolan or Rating 8.8:");
        movieList.searchByDirectorOrRating("Christopher Nolan", 8.8);

        // Removing a movie by title
        movieList.removeMovieByTitle("The Dark Knight");
        System.out.println("After removing The Dark Knight :");
        movieList.displayMovies();

        // Updating the rating of a movie
        movieList.updateRating("Inception", 9.1);
        System.out.println("After updating rating of 'Inception':");
        movieList.displayMovies();
    }
}