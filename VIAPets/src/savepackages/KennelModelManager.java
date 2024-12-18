package savepackages;

import Model.*;
import Utils.MyFileHandler;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class KennelModelManager {
    private String fileName;

    public KennelModelManager() {
        this.fileName = "Kennel.bin";
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<KennelPlace> getKennelPlacesAsArrayList() {
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            ArrayList<KennelPlace> kennelPlaces = new ArrayList<>();
            for (Object obj : objects) {
                kennelPlaces.add((KennelPlace) obj);
            }
            return kennelPlaces;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Kennel getKennel() {
        Kennel kennel = new Kennel();
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            for (Object obj : objects) {
                KennelPlace kennelPlace = (KennelPlace) obj;
                kennel.addPlace(kennelPlace);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kennel;
    }

    public void editKennel() {
        try {
            // Read all existing pets from the file
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(this.fileName);

            Kennel kennel = new Kennel();

            for (Object obj : objects) {
                KennelPlace kennelPlace = (KennelPlace) obj;

                BookingListModelManager bookingListModelManager = new BookingListModelManager();
                Object[] objectsOfBookings = MyFileHandler.readArrayFromBinaryFile(bookingListModelManager.getFileName());
                if (objectsOfBookings.length > 0) {
                    for (Object objOfBookings : objectsOfBookings) {
                        KennelPlace booking = (KennelPlace) objOfBookings;
                        Date dateToCheckIn = new Date(booking.getDateIn().getDay(), booking.getDateIn().getMonth(), booking.getDateIn().getYear());
                        Date dateToCheckOut = new Date(booking.getDateOut().getDay(), booking.getDateOut().getMonth(), booking.getDateOut().getYear());
                        LocalDate today = LocalDate.now();
                        if (dateToCheckIn.before(new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear())) &&
                                dateToCheckOut.after(new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear()))) {
                            kennelPlace.setOccupied(true);
                            break;
                        } else {
                            kennelPlace.setOccupied(false);
                        }
                    }
                    kennel.addPlace(kennelPlace);
                }
            }
            saveKennel(kennel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveKennel(Kennel kennel) {
        try {
            MyFileHandler.writeArrayToBinaryFile(this.fileName, kennel.getAllKennelPlaces().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addKennelPlace(Price price) {
        try {
            Kennel kennel = getKennel();
            kennel.addKennelPlace(price);
            saveKennel(kennel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
