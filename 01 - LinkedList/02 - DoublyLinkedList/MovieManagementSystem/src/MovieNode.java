public class MovieNode {
    private String movieTitle;
    private String director;
    private int yearOfRelease;
    private double rating;
    private MovieNode next;
    private MovieNode prev;


    public MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return yearOfRelease;
    }
    public void setYear(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public MovieNode getNext() {
        return next;
    }
    public void setNext(MovieNode next) {
        this.next = next;
    }

    public MovieNode getPrev() {
        return prev;
    }
    public void setPrev(MovieNode prev) {
        this.prev = prev;
    }

}
