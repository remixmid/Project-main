package savepackages;

import Model.BookingList;
import Model.Kennel;
import Model.KennelPlace;
import Utils.MyFileHandler;

import java.io.File;
import java.util.Date;

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

    public void addBooking(KennelPlace kennelPlaceToAdd) {
        try {
            // Get existing bookings
            BookingList existingBookings = getAllBookings();

            // Check for date conflicts for the same kennel place
            for (KennelPlace existing : existingBookings.getBookingList()) {
                if (existing.getKennelPlaceId() == kennelPlaceToAdd.getKennelPlaceId()) {
                    // Check if dates overlap
                    boolean overlap = isDateOverlap(
                            kennelPlaceToAdd.getDateIn(),
                            kennelPlaceToAdd.getDateOut(),
                            existing.getDateIn(),
                            existing.getDateOut()
                    );

                    if (overlap) {
                        throw new IllegalStateException("This kennel place is already booked for the selected dates.");
                    }
                }
            }

            // If no conflicts, add the booking
            BookingList bookingList = getAllBookings();
            bookingList.addBooking(
                    kennelPlaceToAdd.getDateIn(),
                    kennelPlaceToAdd.getDateOut(),
                    kennelPlaceToAdd.getPet(),
                    kennelPlaceToAdd.getPrice()
            );
            saveBookingList(bookingList);

        } catch (Exception e) {
            throw new RuntimeException("Error adding booking: " + e.getMessage(), e);
        }
    }

    private boolean isDateOverlap(Date start1, Date end1, Date start2, Date end2) {
        // Convert all dates to milliseconds for accurate comparison
        long start1Ms = start1.getTime();
        long end1Ms = end1.getTime();
        long start2Ms = start2.getTime();
        long end2Ms = end2.getTime();

        // Check if either date range is contained within the other
        return !(end1Ms <= start2Ms || start1Ms >= end2Ms);
    }

    // Rest of your existing methods remain the same
    public String getFileName() {
        return fileName;
    }

    public BookingList getAllBookings() {
        BookingList bookingList = new BookingList();
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            if (objects != null && objects.length > 0) {
                for (Object obj : objects) {
                    KennelPlace kennelPlace = (KennelPlace) obj;
                    bookingList.addBooking(
                            kennelPlace.getDateIn(),
                            kennelPlace.getDateOut(),
                            kennelPlace.getPet(),
                            kennelPlace.getPrice()
                    );
                }
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
}