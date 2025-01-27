import java.util.ArrayList;
import java.util.List;

class Room {
    private int roomId;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomId, String category, double price) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

class Reservation {
    private int roomId;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    private String paymentStatus;

    public Reservation(int roomId, String guestName, String checkInDate, String checkOutDate) {
        this.roomId = roomId;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentStatus = "Pending";
    }

    public int getRoomId() {
        return roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomId=" + roomId +
                ", guestName='" + guestName + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(int roomId, String category, double price) {
        rooms.add(new Room(roomId, category, price));
    }

    public List<Room> searchRooms(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && (category == null || room.getCategory().equalsIgnoreCase(category))) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation makeReservation(int roomId, String guestName, String checkInDate, String checkOutDate) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId && room.isAvailable()) {
                room.setAvailable(false);
                Reservation reservation = new Reservation(roomId, guestName, checkInDate, checkOutDate);
                reservations.add(reservation);
                return reservation;
            }
        }
        return null;
    }

    public List<Reservation> viewReservations(String guestName) {
        List<Reservation> filteredReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (guestName == null || reservation.getGuestName().equalsIgnoreCase(guestName)) {
                filteredReservations.add(reservation);
            }
        }
        return filteredReservations;
    }

    public boolean processPayment(int roomId) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomId() == roomId) {
                reservation.setPaymentStatus("Completed");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();

        
        system.addRoom(101, "Single", 100);
        system.addRoom(102, "Double", 150);
        system.addRoom(103, "Suite", 250);

        
        System.out.println("Available Rooms: " + system.searchRooms(null));
        System.out.println("Available Suites: " + system.searchRooms("Suite"));

        
        Reservation reservation = system.makeReservation(103, "John Doe", "2025-06-01", "2025-06-05");
        System.out.println("Reservation: " + reservation);

        
        System.out.println("All Reservations: " + system.viewReservations(null));

        
        boolean paymentProcessed = system.processPayment(103);
        System.out.println("Payment Processed: " + paymentProcessed);

        
        System.out.println("Updated Reservations: " + system.viewReservations(null));
    }
}