package rentalstore.statement;

import rentalstore.Rental;

public class HtmlStatement extends Statement {
    @Override
    public String getHeader(String customerName) {
        return "<H1>Rental Record for <EM>" + customerName + "</EM></H1>";
    }

    @Override
    public String getRentalItem(Rental rental, double thisAmount) {
        return "<p>\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "<BR></p>";
    }

    @Override
    public String getFooter(double totalAmount, int frequentRenterPoints) {
        String footer = "<p>Amount owed is <EM>" + totalAmount + "</EM></p>";
        footer += "<p>You earned <EM>" + frequentRenterPoints + "</EM> frequent renter points</p>";
        return footer;
    }
}
