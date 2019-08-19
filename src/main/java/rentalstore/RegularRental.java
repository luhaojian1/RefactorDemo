package rentalstore;

public class RegularRental implements MovieRental {

    @Override
    public double getItemAmount(int rentalDay) {
        double thisAmount = 2;
        if (rentalDay > 2) {
            thisAmount += (rentalDay - 2) * 1.5;
        }
        return thisAmount;
    }

    @Override
    public int getItemPoints(int rentalDay) {
        return 1;
    }
}
