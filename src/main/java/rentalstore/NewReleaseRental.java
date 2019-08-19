package rentalstore;

public class NewReleaseRental implements MovieRental {


    @Override
    public double getItemAmount(int rentalDay) {
        return rentalDay * 3;
    }

    @Override
    public int getItemPoints(int rentalDay) {
        return rentalDay > 1 ? 2 : 1;
    }

}
