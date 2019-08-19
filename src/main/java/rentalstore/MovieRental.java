package rentalstore;

public interface MovieRental {
    public abstract double getItemAmount(int rentalDay);

    public abstract int getItemPoints(int rentalDay);
}
