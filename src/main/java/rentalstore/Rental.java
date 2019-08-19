package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;
    private MovieRental movieRental;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Rental(Movie movie, int dayRented, MovieRental movieRental) {
        this.movie = movie;
        this.dayRented = dayRented;
        this.movieRental = movieRental;
    }


    public Movie getMovie() {
        return movie;
    }

    public double getItemAmount() {
        return movieRental.getItemAmount(dayRented);
    }

    public int getItemPoints() {
        return movieRental.getItemPoints(dayRented);
    }
}
