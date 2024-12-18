package savepackages;

import Model.*;
import Utils.MyFileHandler;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class KennelModelManager {
    private String fileName;

    public KennelModelManager() {
        this.fileName = "Kennel.bin";
        try {
            File file = new File(this.fileName);
            System.out.println("Attempting to create file at: " + file.getAbsolutePath());

            if (!file.exists()) {
                boolean created = file.createNewFile();
                System.out.println("File creation attempt: " + created);
            }

            System.out.println("Can write to file: " + file.canWrite());
        } catch (Exception e) {
            System.err.println("Error initializing kennel file:");
            e.printStackTrace();
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
            if (objects != null) {
                for (Object obj : objects) {
                    if (obj instanceof KennelPlace) {
                        KennelPlace kennelPlace = (KennelPlace) obj;
                        kennel.addPlace(kennelPlace);
                    }
                }
            }
        } catch (EOFException e) {
            // File is empty or not properly initialized
            System.out.println("Kennel file is empty. Creating a new kennel.");
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
            // Ensure the directory exists
            File file = new File(this.fileName);
            file.getParentFile().mkdirs(); // Create parent directories if they don't exist

            // Use try-with-resources to ensure the stream is properly closed
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                // Get the list of kennel places
                ArrayList<KennelPlace> kennelPlaces = kennel.getAllKennelPlaces();

                // Write the list to the file
                oos.writeObject(kennelPlaces.toArray(new KennelPlace[0]));
            }
        } catch (Exception e) {
            System.err.println("Error saving kennel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addKennelPlace(Price price) {
        try {
            Kennel kennel = getKennel();
            kennel.addKennelPlace(price);
            saveKennel(kennel);
            System.out.println("Kennel place added successfully"); // Debug print
        } catch (Exception e) {
            System.err.println("Error adding kennel place: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
