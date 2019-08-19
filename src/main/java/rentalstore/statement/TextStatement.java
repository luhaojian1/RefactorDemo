package rentalstore.statement;

import rentalstore.Rental;

public class TextStatement extends Statement {
    @Override
    public String getHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    @Override
    public String getRentalItem(Rental rental, double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    @Override
    public String getFooter(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
