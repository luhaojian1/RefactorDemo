package rentalstore.statement;

import rentalstore.Customer;
import rentalstore.Rental;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Statement {
    abstract String getHeader(String customerName);

    abstract String getRentalItem(Rental rental, double thisAmount);

    abstract String getFooter(double totalAmount, int frequentRenterPoints);

    public String getBody(List<Rental> rentals) {
        return rentals.stream().
                map(rental -> getRentalItem(rental, rental.getItemAmount()))
                .collect(Collectors.joining());
    }

    public String statement(Customer customer) {
        return getHeader(customer.getName())
                + getBody(customer.getRentals())
                + getFooter(customer.getTotalAmount(), customer.getTotalPoints());
    }
}
