package rentalstore;

public class ChildrenRental implements MovieRental {


    @Override
    public double getItemAmount(int rentalDay) {
        double thisAmount = 1.5;
        if (rentalDay > 3) {
            thisAmount += (rentalDay - 3) * 1.5;
        }
        return thisAmount;
    }

    @Override
    public int getItemPoints(int rentalDay) {
        return 1;
    }
}
