package savepackages;

import Model.BookingList;
import Model.KennelPlace;
import Utils.MyFileHandler;

import java.io.File;

public class BookingListModelManager {
    private String fileName;

    public BookingListModelManager() {
        this.fileName = "Bookings.bin";
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BookingList getAllBookings() {
        BookingList bookingList = new BookingList();

        try {

            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);

            for(Object obj : objects) {
                KennelPlace kennelPlace = (KennelPlace) obj;
                bookingList.addBooking(kennelPlace.getDateIn(), kennelPlace.getDateOut(), kennelPlace.getPet(), kennelPlace.getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public void saveBookingList(BookingList bookingList) {
        try {
            MyFileHandler.writeArrayToBinaryFile(fileName, bookingList.getBookingList().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editBookingList(KennelPlace kennelPlaceToChange, KennelPlace newKennelPlace) {
        BookingList bookingList = getAllBookings();
        try {
            for (KennelPlace kennelPlaceFromList : bookingList.getBookingList()) {
                if(kennelPlaceFromList.equals(kennelPlaceToChange))
                    kennelPlaceFromList = newKennelPlace;
        }
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBooking(KennelPlace kennelPlaceToDelete) {
        try {
            BookingList bookingList = getAllBookings();
            bookingList.removeBooking(kennelPlaceToDelete);
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBooking(KennelPlace kennelPlaceToAdd) {
        try {
            BookingList bookingList = getAllBookings();
            bookingList.addBooking(kennelPlaceToAdd.getDateIn(), kennelPlaceToAdd.getDateOut(), kennelPlaceToAdd.getPet(), kennelPlaceToAdd.getPrice());
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
