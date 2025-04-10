import org.example.ticketbookingsystem.controller.*;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.Show;
import org.example.ticketbookingsystem.provider.InMemorySeatLockProvider;
import org.example.ticketbookingsystem.provider.SeatLockProvider;
import org.example.ticketbookingsystem.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieTest {

    MovieController movieController;
    ShowController showController;
    TheatreController theatreController;
    BookingController bookingController;
    PaymentController paymentController;
    String theatreId1;
    String screenId1;
    @BeforeEach
    void setUp() {

        ShowService showService = new ShowService();
        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        SeatLockProvider seatLockProvider = new InMemorySeatLockProvider();
        BookingService bookingService = new BookingService(seatLockProvider);
        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(theatreService, bookingService,seatLockProvider);
        PaymentService paymentService = new PaymentService(seatLockProvider);

         movieController = new MovieController(movieService);
         showController = new ShowController(showService, theatreService, movieService, seatAvailabilityService);
         theatreController = new TheatreController(theatreService);
         bookingController = new BookingController(bookingService, theatreService,showService);
         paymentController = new PaymentController(paymentService, bookingService);
    }

    protected String setUpScreen() {
         theatreId1 = theatreController.addTheatre("Theatre 1");
         screenId1 = theatreController.addScreenToTheatre(theatreId1, "AUDI 1");
         return screenId1;
    }

    protected List<String> addSeatsToTheatre(String screenId , int rows, int seats ) {
        List<String> seatList = new ArrayList<>();
        for(int i =0;i<rows ;i++) {
            for(int j =0;j<seats;j++) {
                String seat = theatreController.addSeatToScreen(screenId, i, j);
                seatList.add(seat);
            }
        }
        return seatList;
    }

    @Test
    public void test01() {
        String screenId = setUpScreen();
        List<String> seats = addSeatsToTheatre(screenId, 10, 10);
        String movieId = movieController.addMovie("Hum Tum");

        String showId = showController.createShow(movieId, screenId, "Evening Show" , Date.from(Instant.now()) , Date.from(Instant.now()));
        List<Show> showList = showController.getShowsRunningOnScreen(screenId);

        for(Show show : showList) {
            System.out.println(show.getName());
            System.out.println(show.getMovie().getMovieName());
            System.out.println(show.getStartTime());
        }
    }

    @Test
    public void test02() {
        // Setup Screen and Movies

        String screenId = setUpScreen();
        List<String> seats = addSeatsToTheatre(screenId, 5, 5);
        String movieId = movieController.addMovie("Hum Tum");

        String showId = showController.createShow(movieId, screenId, "Evening Show" , Date.from(Instant.now()) , Date.from(Instant.now()));

        // Available Shows for a Screen
        List<Show> showList = showController.getShowsRunningOnScreen(screenId);

        for(Show show : showList) {
            System.out.println(show.getName());
            System.out.println(show.getMovie().getMovieName());
            System.out.println(show.getStartTime());
        }

        // Available Seats for a show
        List<Seat> availableSeats = showController.getSeatAvailability(showId);

        for(Seat seat : availableSeats) {
            System.out.println("===============");
            System.out.println(seat.getRow()  + " "+  seat.getSeatNo()+ " " + seat.getSeatType());
        }

        List<String> seatsToBook = new ArrayList<>();
        seatsToBook.add(availableSeats.get(0).getId());
        seatsToBook.add(availableSeats.get(1).getId());
        seatsToBook.add(availableSeats.get(2).getId());
        seatsToBook.add(availableSeats.get(3).getId());
        seatsToBook.add(availableSeats.get(4).getId());
        seatsToBook.add(availableSeats.get(5).getId());


//        String bookingId = bookingController.bookTicket(seatsToBook, showId, "USER1");
//        System.out.println("Booking ID " + bookingId);

        // Create Booking -

        String bookingId = bookingController.createBooking(seatsToBook, showId, "USER1");
        System.out.println("Booking Id" + bookingId);

        // Complete Payment for a Booking ID (Confirm Booking)
        paymentController.paymentSuccess(bookingId);

        //  Payment Failed for a Booking ID (Confirm Booking)
//        paymentController.paymentFailed(bookingId, "USER1");


        try {
            String bookingId2 = bookingController.createBooking(seatsToBook, showId, "USER1");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Seat> availableSeats2 = showController.getSeatAvailability(showId);
        for(Seat seat : availableSeats2) {
            System.out.println("==================");
            System.out.println(seat.getRow() + "  " + seat.getSeatNo() + " " + seat.getSeatType());
        }

    }

    @Test
    public void test03() {
        // Setup Screen and Movies

        String screenId = setUpScreen();
        List<String> seats = addSeatsToTheatre(screenId, 5, 5);
        String movieId = movieController.addMovie("Hum Tum");

        String showId = showController.createShow(movieId, screenId, "Evening Show" , Date.from(Instant.now()) , Date.from(Instant.now()));

        // Available Shows for a Screen
        List<Show> showList = showController.getShowsRunningOnScreen(screenId);

        for(Show show : showList) {
            System.out.println(show.getName());
            System.out.println(show.getMovie().getMovieName());
            System.out.println(show.getStartTime());
        }

        // Available Seats for a show
        List<Seat> availableSeats = showController.getSeatAvailability(showId);

        for(Seat seat : availableSeats) {
            System.out.println("===============");
            System.out.println(seat.getRow()  + " "+  seat.getSeatNo()+ " " + seat.getSeatType());
        }

        List<String> seatsToBook = new ArrayList<>();
        seatsToBook.add(availableSeats.get(0).getId());
        seatsToBook.add(availableSeats.get(1).getId());
        seatsToBook.add(availableSeats.get(2).getId());
        seatsToBook.add(availableSeats.get(3).getId());
        seatsToBook.add(availableSeats.get(4).getId());
        seatsToBook.add(availableSeats.get(5).getId());


//        String bookingId = bookingController.bookTicket(seatsToBook, showId, "USER1");
//        System.out.println("Booking ID " + bookingId);

        // Create Booking -

        String bookingId = bookingController.createBooking(seatsToBook, showId, "USER1");
        System.out.println("Booking Id" + bookingId);

        //  Payment Failed for a Booking ID (Confirm Booking)
        paymentController.paymentFailed(bookingId, "USER1");

        List<Seat> availableSeats2 = showController.getSeatAvailability(showId);
        for(Seat seat : availableSeats2) {
            System.out.println("==================");
            System.out.println(seat.getRow() + "  " + seat.getSeatNo() + " " + seat.getSeatType());
        }

    }



}
