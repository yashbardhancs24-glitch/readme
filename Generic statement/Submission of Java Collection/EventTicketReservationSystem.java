package Collections;
import java.util.*;

class Booking implements Comparable<Booking> {
    String userId;
    boolean isVip;
    String event;

    Booking(String userId, boolean isVip, String event) {
        this.userId = userId;
        this.isVip = isVip;
        this.event = event;
    }

    public int compareTo(Booking other) {
        if (this.isVip && !other.isVip) return -1;
        else if (!this.isVip && other.isVip) return 1;
        else return this.userId.compareTo(other.userId);
    }

    public String toString() {
        return userId + (isVip ? " (VIP)" : "") + ": " + event;
    }
}

public class EventTicketReservationSystem {
    List<Booking> allBookings = new ArrayList<>();
    Set<String> registeredUsers = new HashSet<>();
    Queue<Booking> bookingQueue = new LinkedList<>();
    PriorityQueue<Booking> vipPriorityQueue = new PriorityQueue<>();

    public boolean registerUser(String userId) {
        return registeredUsers.add(userId);
    }

    public boolean addBooking(Booking booking) {
        if (!registeredUsers.contains(booking.userId)) {
            return false;
        }
        bookingQueue.add(booking);
        if (booking.isVip) {
            vipPriorityQueue.add(booking);
        }
        return true;
    }

    public void confirmBookings() {
        while (!vipPriorityQueue.isEmpty()) {
            Booking vipBooking = vipPriorityQueue.poll();
            allBookings.add(vipBooking);
            bookingQueue.remove(vipBooking);
        }
        while (!bookingQueue.isEmpty()) {
            Booking b = bookingQueue.poll();
            allBookings.add(b);
        }
    }

    public void displayAllBookings() {
        for (Booking b : allBookings) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        EventTicketReservationSystem system = new EventTicketReservationSystem();

        system.registerUser("user1");
        system.registerUser("user2");
        system.registerUser("user3");

        system.addBooking(new Booking("user1", false, "Concert"));
        system.addBooking(new Booking("user2", true, "VIP Gala"));
        system.addBooking(new Booking("user3", false, "Play"));

        system.confirmBookings();

        system.displayAllBookings();
    }
}


