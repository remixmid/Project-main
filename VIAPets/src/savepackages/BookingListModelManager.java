package savepackages;

import Model.BookingList;
import Model.KennelPlace;
import Utils.MyFileHandler;

import java.io.File;

public class BookingListModelManager {
    private String fileName;

    // Constructor to initialize the file name and create the file if it doesn't exist
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

    // Method to get the file name
    public String getFileName() {
        return fileName;
    }

    // Method to retrieve all bookings from the binary file
    public BookingList getAllBookings() {
        BookingList bookingList = new BookingList();

        try {
            // Read objects from the binary file
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);

            // Convert objects to KennelPlace and add to the booking list
            for(Object obj : objects) {
                KennelPlace kennelPlace = (KennelPlace) obj;
                bookingList.addBooking(kennelPlace.getDateIn(), kennelPlace.getDateOut(), kennelPlace.getPet(), kennelPlace.getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    // Method to save the booking list to the binary file
    public void saveBookingList(BookingList bookingList) {
        try {
            // Write the booking list to the binary file
            MyFileHandler.writeArrayToBinaryFile(fileName, bookingList.getBookingList().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to edit an existing booking in the list
    public void editBookingList(KennelPlace kennelPlaceToChange, KennelPlace newKennelPlace) {
        BookingList bookingList = getAllBookings();
        try {
            // Find the booking to change and replace it
            for (KennelPlace kennelPlaceFromList : bookingList.getBookingList()) {
                if(kennelPlaceFromList.equals(kennelPlaceToChange))
                    kennelPlaceFromList = newKennelPlace;
            }
            // Save the updated booking list
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete a booking from the list
    public void deleteBooking(KennelPlace kennelPlaceToDelete) {
        try {
            // Retrieve the booking list and remove the booking
            BookingList bookingList = getAllBookings();
            bookingList.removeBooking(kennelPlaceToDelete);
            // Save the updated booking list
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add a new booking to the list
    public void addBooking(KennelPlace kennelPlaceToAdd) {
        try {
            // Retrieve the booking list and add the new booking
            BookingList bookingList = getAllBookings();
            bookingList.addBooking(kennelPlaceToAdd.getDateIn(), kennelPlaceToAdd.getDateOut(), kennelPlaceToAdd.getPet(), kennelPlaceToAdd.getPrice());
            // Save the updated booking list
            saveBookingList(bookingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
