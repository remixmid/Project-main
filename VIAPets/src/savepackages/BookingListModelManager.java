package savepackages;

import Model.BookingList;
import Model.KennelPlace;
import Utils.MyFileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class BookingListModelManager {
    private String fileName;

    public BookingListModelManager() {
        this.fileName = "Bookings.bin";
        initializeFile();
    }

    private void initializeFile() {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                BookingList emptyList = new BookingList();
                saveBookingList(emptyList);
                System.out.println("Created new bookings file: " + fileName);
            }
        } catch (Exception e) {
            System.err.println("Error initializing bookings file: " + e.getMessage());
            throw new RuntimeException("Failed to initialize bookings system", e);
        }
    }

    public void addBooking(KennelPlace kennelPlaceToAdd) {
        if (kennelPlaceToAdd == null) {
            throw new IllegalArgumentException("Cannot add null booking");
        }

        try {
            // Validate the new booking
            validateBooking(kennelPlaceToAdd);

            // Get existing bookings
            BookingList existingBookings = getAllBookings();

            // Add the new booking directly to the list
            existingBookings.addKennelPlace(kennelPlaceToAdd);

            // Save updated booking list
            saveBookingList(existingBookings);
            System.out.println("Successfully added booking for kennel place: " + kennelPlaceToAdd.getKennelPlaceId());

        } catch (Exception e) {
            System.err.println("Error adding booking: " + e.getMessage());
            throw new RuntimeException("Failed to add booking: " + e.getMessage(), e);
        }
    }

    private void validateBooking(KennelPlace booking) {
        if (booking.getDateIn() == null || booking.getDateOut() == null) {
            throw new IllegalArgumentException("Booking dates cannot be null");
        }
        if (booking.getDateIn().after(booking.getDateOut())) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }
        if (booking.getPet() == null || booking.getPet().trim().isEmpty()) {
            throw new IllegalArgumentException("Pet information is required");
        }
        if (booking.getPrice() == null) {
            throw new IllegalArgumentException("Booking price is required");
        }
    }

    private void checkForBookingConflicts(KennelPlace newBooking, BookingList existingBookings) {
        for (KennelPlace existing : existingBookings.getBookingList()) {
            if (existing.getKennelPlaceId() == newBooking.getKennelPlaceId()) {
                if (hasDateOverlap(newBooking.getDateIn(), newBooking.getDateOut(),
                        existing.getDateIn(), existing.getDateOut())) {
                    throw new IllegalStateException(
                            "Kennel place " + newBooking.getKennelPlaceId() +
                                    " is already booked between " + existing.getDateIn() +
                                    " and " + existing.getDateOut());
                }
            }
        }
    }

    private boolean hasDateOverlap(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    public BookingList getAllBookings() {
        try {
            BookingList bookingList = new BookingList();
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);

            if (objects != null && objects.length > 0) {
                for (Object obj : objects) {
                    if (obj instanceof KennelPlace) {
                        KennelPlace booking = (KennelPlace) obj;
                        // Use addKennelPlace to ensure proper copying
                        bookingList.addKennelPlace(booking);

                        System.out.println("Loaded booking: Kennel ID=" + booking.getKennelPlaceId() +
                                ", Pet=" + booking.getPet() +
                                ", DateIn=" + booking.getDateIn() +
                                ", DateOut=" + booking.getDateOut());
                    }
                }
            }

            System.out.println("Total bookings loaded: " + bookingList.getBookingList().size());
            return bookingList;

        } catch (Exception e) {
            System.err.println("Error loading bookings: " + e.getMessage());
            e.printStackTrace();
            return new BookingList();
        }
    }

    public void saveBookingList(BookingList bookingList) {
        if (bookingList == null) {
            throw new IllegalArgumentException("Cannot save null booking list");
        }

        try {
            ArrayList<KennelPlace> bookings = bookingList.getBookingList();
            Object[] bookingsArray = bookings.toArray();
            MyFileHandler.writeArrayToBinaryFile(fileName, bookingsArray);
            System.out.println("Successfully saved " + bookingsArray.length + " bookings");

        } catch (Exception e) {
            System.err.println("Error saving bookings: " + e.getMessage());
            throw new RuntimeException("Failed to save bookings", e);
        }
    }

    public void deleteBooking(int kennelPlaceId, Date dateIn) {
        try {
            BookingList bookingList = getAllBookings();
            ArrayList<KennelPlace> bookings = bookingList.getBookingList();

            boolean found = false;
            for (int i = 0; i < bookings.size(); i++) {
                KennelPlace booking = bookings.get(i);
                if (booking.getKennelPlaceId() == kennelPlaceId &&
                        booking.getDateIn().equals(dateIn)) {
                    bookings.remove(i);
                    found = true;
                    break;
                }
            }

            if (found) {
                saveBookingList(bookingList);
                System.out.println("Successfully deleted booking for kennel place: " + kennelPlaceId);
            } else {
                throw new IllegalArgumentException("Booking not found for kennel place: " + kennelPlaceId);
            }

        } catch (Exception e) {
            System.err.println("Error deleting booking: " + e.getMessage());
            throw new RuntimeException("Failed to delete booking", e);
        }
    }
    private void debugPrintBookings(String location, BookingList bookingList) {
        System.out.println("\n=== DEBUG: " + location + " ===");
        System.out.println("Number of bookings: " +
                (bookingList != null ? bookingList.getBookingList().size() : 0));
        if (bookingList != null && bookingList.getBookingList() != null) {
            for (KennelPlace booking : bookingList.getBookingList()) {
                System.out.println("  Booking: ID=" + booking.getKennelPlaceId() +
                        ", Pet=" + booking.getPet() +
                        ", DateIn=" + booking.getDateIn() +
                        ", DateOut=" + booking.getDateOut());
            }
        }
        System.out.println("=== END DEBUG ===\n");
    }
}