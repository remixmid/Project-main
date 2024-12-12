package Model;

import java.util.ArrayList;
import java.util.Date;

public class BookingList {
    private ArrayList<KennelPlace> bookingList;

    public BookingList() {
        bookingList = new ArrayList<>();
    }

    public ArrayList<KennelPlace> getBookingList() {
        return bookingList;
    }

    public void addBooking(Date dateIn, Date dateOut, Pet pet, Price price){
        Date dateFrom = new Date(dateIn.getDay(), dateIn.getMonth(), dateIn.getYear());
        Date dateTo = new Date(dateOut.getDay(), dateOut.getMonth(), dateOut.getYear());
        Date dateToCheckIn;
        Date dateToCheckOut;

        for (KennelPlace kennelPlace: bookingList) {
            dateToCheckIn = new Date(kennelPlace.getDateIn().getDay(), kennelPlace.getDateIn().getMonth(),
                    kennelPlace.getDateIn().getYear());
            dateToCheckOut = new Date(kennelPlace.getDateOut().getDay(), kennelPlace.getDateOut().getMonth(),
                     kennelPlace.getDateOut().getYear());
            if (!dateFrom.after(dateToCheckIn) && !dateFrom.before(dateToCheckOut)){
                if (!dateTo.after(dateToCheckIn) && !dateTo.before(dateToCheckOut)){
                    KennelPlace newKennelPlace = kennelPlace.copy();
                    newKennelPlace.setPet(pet);
                    newKennelPlace.setPrice(price);
                    newKennelPlace.setDateIn(dateIn);
                    newKennelPlace.setDateOut(dateOut);
                    newKennelPlace.setOccupied(true);
                    bookingList.add(newKennelPlace);
                    return;
                }
            }
        }
    }

    public void removeBooking(KennelPlace kennelPlace) {
        if (bookingList.contains(kennelPlace))
            bookingList.remove(kennelPlace);
    }
}
