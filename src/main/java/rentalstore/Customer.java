package rentalstore;

import rentalstore.statement.HtmlStatement;
import rentalstore.statement.Statement;
import rentalstore.statement.TextStatement;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : this.rentals) {
            totalAmount += each.getItemAmount();
        }
        return totalAmount;
    }

    public int getTotalPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this.rentals) {
            frequentRenterPoints += each.getItemPoints();
        }
        return frequentRenterPoints;
    }

    public String statement() {
        Statement statement = new TextStatement();
        return statement.statement(this);
    }

    public String htmlStatement() {
        Statement statement = new HtmlStatement();
        return statement.statement(this);
    }


}
