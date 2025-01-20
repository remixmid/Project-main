package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class BookingList implements Serializable {
    private ArrayList<KennelPlace> bookings;

    public BookingList() {
        bookings = new ArrayList<>();
    }

    public void addBooking(Date dateIn, Date dateOut, String pet, Price price, int kennelPlaceId) {
        KennelPlace booking = new KennelPlace(price);
        booking.setDateIn(dateIn);
        booking.setDateOut(dateOut);
        booking.setPet(pet);
        booking.setKennelPlaceId(kennelPlaceId);  // Set the ID!
        booking.setOccupied(true);
        bookings.add(booking);
    }

    // Keep this method for direct KennelPlace additions
    public void addKennelPlace(KennelPlace kennelPlace) {
        // Make a deep copy to ensure all properties are preserved
        KennelPlace copy = new KennelPlace(kennelPlace.getPrice());
        copy.setDateIn(kennelPlace.getDateIn());
        copy.setDateOut(kennelPlace.getDateOut());
        copy.setPet(kennelPlace.getPet());
        copy.setKennelPlaceId(kennelPlace.getKennelPlaceId());
        copy.setOccupied(true);
        bookings.add(copy);
    }

    public ArrayList<KennelPlace> getBookingList() {
        return bookings;
    }
}