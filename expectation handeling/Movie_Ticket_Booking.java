package Exception;
import java.util.HashMap;
import java.util.Map;

// Custom exceptions
class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

// Movie ticket booking class
class MovieBooking {
    private Map<String, Boolean> seats;

    public MovieBooking() {
        seats = new HashMap<>();
        // Initialize seats A1 to A5 as available (true)
        seats.put("A1", true);
        seats.put("A2", true);
        seats.put("A3", true);
        seats.put("A4", true);
        seats.put("A5", true);
    }

    public void bookSeat(String seatNumber) throws InvalidSeatException, SeatAlreadyBookedException {
        if (!seats.containsKey(seatNumber)) {
            throw new InvalidSeatException("Seat number does not exist: " + seatNumber);
        }

        if (!seats.get(seatNumber)) {
            throw new SeatAlreadyBookedException("Seat already booked: " + seatNumber);
        }

        seats.put(seatNumber, false); // mark seat as booked
        System.out.println("Seat " + seatNumber + " booked successfully.");
    }
}

// Main class
public class Movie_Ticket_Booking {
    public static void main(String[] args) {
        MovieBooking booking = new MovieBooking();

        try {
            booking.bookSeat("A1"); // success
            booking.bookSeat("A1"); // already booked
        } catch (InvalidSeatException | SeatAlreadyBookedException e) {
            System.out.println("Booking error: " + e.getMessage());
        }

        try {
            booking.bookSeat("B1"); // invalid seat
        } catch (InvalidSeatException | SeatAlreadyBookedException e) {
            System.out.println("Booking error: " + e.getMessage());
        }
    }
}


