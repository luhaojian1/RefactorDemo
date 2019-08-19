package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {


    @Test
    public void should_return_a_statement_not_total_amount_when_not_rental_movie() {

        Customer customer = new Customer("John");

        String statement = customer.statement();

        assertEquals("Rental Record for John\n" + "Amount owed is 0.0\n" + "You earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_a_statement_when_customer_rental_movie_is_regular_and_two_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.REGULAR);
        MovieRental movieRental = new RegularRental();
        Rental rental = new Rental(movie, 2, movieRental);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for John\n"
                + "\tMovie 1\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_a_statement_when_customer_rental_movie_is_regular_and_three_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.REGULAR);
        MovieRental movieRental = new RegularRental();
        Rental rental = new Rental(movie, 3, movieRental);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for John\n"
                + "\tMovie 1\t3.5\n"
                + "Amount owed is 3.5\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_a_statement_when_customer_rental_movie_is_new_release_and_three_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.NEW_RELEASE);
        MovieRental movieRental = new NewReleaseRental();
        Rental rental = new Rental(movie, 3, movieRental);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for John\n"
                + "\tMovie 1\t9.0\n"
                + "Amount owed is 9.0\n"
                + "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_a_statement_when_customer_rental_movie_is_children_and_three_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.CHILDRENS);
        MovieRental movieRental = new ChildrenRental();
        Rental rental = new Rental(movie, 3, movieRental);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for John\n"
                + "\tMovie 1\t1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_a_statement_when_customer_rental_movie_is_children_and_four_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.CHILDRENS);
        MovieRental movieRental = new ChildrenRental();
        Rental rental = new Rental(movie, 4, movieRental);
        customer.addRental(rental);

        String statement = customer.statement();

        assertEquals("Rental Record for John\n"
                + "\tMovie 1\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_a_html_statement_when_customer_rental_movie_is_children_and_four_days() {

        Customer customer = new Customer("John");
        Movie movie = new Movie("Movie 1", Movie.CHILDRENS);
        MovieRental movieRental = new ChildrenRental();
        Rental rental = new Rental(movie, 4, movieRental);
        customer.addRental(rental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>John</EM></H1>"
                + "<p>\tMovie 1\t3.0<BR></p>"
                + "<p>Amount owed is <EM>3.0</EM></p>"
                + "<p>You earned <EM>1</EM> frequent renter points</p>", statement);
    }
}
