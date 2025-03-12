package org.example.designPattern.BookyMyShow;

import org.example.designPattern.BookyMyShow.controller.BookingsController;
import org.example.designPattern.BookyMyShow.controller.MovieController;
import org.example.designPattern.BookyMyShow.controller.TheatreController;
import org.example.designPattern.BookyMyShow.model.*;
import org.example.designPattern.BookyMyShow.service.BookingService;
import org.example.designPattern.BookyMyShow.service.MovieService;
import org.example.designPattern.BookyMyShow.service.TheatreService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookMyShowAppDemo {

    static Movie movie1;
    static Movie movie2;
    static Movie movie3;

    public static void main(String[] args) {

        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        BookingService bookingService = new BookingService();
        MovieController movieController = new MovieController(movieService);
        TheatreController theatreController = new TheatreController(theatreService);
        BookingsController bookingsController = new BookingsController(bookingService);
        BookMyShowApp bookMyShowApp = new BookMyShowApp(theatreController, movieController, bookingsController);

        initializeApp(bookMyShowApp);

        /*
        Get All Movies For a Location
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Location of City - ");
        String location = scanner.nextLine();
        List<Movie> movies = bookMyShowApp.getMoviesForLocation(location);
        movies.stream().forEach(movie -> System.out.println(movie.getMovieDetails()));

        System.out.println("Select a Movie Number - ");
        int movieIndex = scanner.nextInt();

        List<Show> runningShows = bookMyShowApp.getAllShowsForAMovie("Banglore", movies.get(movieIndex));
        runningShows.stream().forEach(show -> System.out.println(show.getMovie().getMovieDetails() + " in " + show.getAssociatedScreen().getScreenId()));

        List<Integer> freeSeats = bookMyShowApp.getFreeSeats(runningShows.get(0));

        System.out.println("Selecting Free Seats - ");
        System.out.println("Booking Free Seats Selected in " + runningShows.get(0).getAssociatedScreen().getScreenId());
        String bookingId = bookMyShowApp.bookTickets(runningShows.get(0), 4);
        System.out.println("Booking created - " + bookingId);
        boolean isConfirmed = bookMyShowApp.confirmBooking(bookingId);
        System.out.println("Booking Confirmed - " + isConfirmed);


        System.out.println("Booking Free Seats Selected in " + runningShows.get(0).getAssociatedScreen().getScreenId());
        String bookingId2 = bookMyShowApp.bookTickets(runningShows.get(0), 4);
        System.out.println("Booking created - " + bookingId2);

        boolean isConfirmed2 = bookMyShowApp.confirmBooking(bookingId);
        System.out.println("Booking Confirmed - " + isConfirmed2);


//        System.out.println("Enter Location of City - ");
//        location = scanner.nextLine();
//        List<Movie> movies2 = bookMyShowApp.getMoviesForLocation(location);
//        movies2.stream().forEach(movie -> System.out.println(movie.getMovieDetails()));

        /*
        Select a Movie
         */

//        theatreController.getAllShows("Banglore", movies.get(0));

    }

    private static void initializeApp(BookMyShowApp bookMyShowApp) {
        addMovies(bookMyShowApp);
        addTheatre(bookMyShowApp);
    }

    private static void addMovies(BookMyShowApp bookMyShowApp) {
         movie1 = new Movie("1", "Hum Tum" , 120);
         movie2 = new Movie("2" , "Chup Chup Ke" , 140);
         movie3 = new Movie("3" , "Avengers" , 160);

        bookMyShowApp.addMovies("Banglore", movie1);
        bookMyShowApp.addMovies("Banglore", movie2);
        bookMyShowApp.addMovies("Banglore", movie1);
    }

    private static void addTheatre(BookMyShowApp bookMyShowApp) {
        Theatre theatre1 = new Theatre("1", new ArrayList<>(), new ArrayList<>());
        Theatre theatre2 = new Theatre("2", new ArrayList<>(), new ArrayList<>());

        List<Seat> seatList = new ArrayList<>();
        seatList.add(new Seat(1, false));
        seatList.add(new Seat(2, false));
        seatList.add(new Seat(3, false));
        seatList.add(new Seat(4, false));

        List<Seat> seatList2 = new ArrayList<>();
        seatList2.add(new Seat(1, false));
        seatList2.add(new Seat(2, false));
        seatList2.add(new Seat(3, false));


        List<Seat> seatList3 = new ArrayList<>();
        seatList3.add(new Seat(1, false));
        seatList3.add(new Seat(2, false));
        seatList3.add(new Seat(3, false));
        seatList3.add(new Seat(4, false));
        seatList3.add(new Seat(5, false));


        Screen screen1 = new Screen("s1", seatList);
        Screen screen2 = new Screen("s2" , seatList2);
        Screen screen3 = new Screen("s3", seatList3);

        Show show1 = new Show(new Date(),screen1, new ArrayList<>(), new ArrayList<>(), movie1);
        Show show2 = new Show(new Date(),screen2, new ArrayList<>(), new ArrayList<>(), movie2);
        Show show3 = new Show(new Date(),screen3, new ArrayList<>(), new ArrayList<>(), movie1);

        List<Show> shows = new ArrayList<>();
        List<Screen> screens = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        screens.add(screen1);
        screens.add(screen2);

        theatre1.setScreens(screens);
        theatre1.setShows(shows);

        List<Show> shows2 = new ArrayList<>();
        List<Screen> screens2 = new ArrayList<>();

        shows2.add(show3);
        screens2.add(screen3);

        theatre2.setShows(shows2);
        theatre2.setScreens(screens2);

        bookMyShowApp.addTheatre("Banglore" , theatre1);
        bookMyShowApp.addTheatre("Banglore", theatre2);
    }

}
