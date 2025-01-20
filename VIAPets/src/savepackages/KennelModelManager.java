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
            if (!file.exists()) {
                file.createNewFile();
                // Initialize with default kennel places 1-10
                Kennel kennel = new Kennel();
                for (int i = 1; i <= 10; i++) {
                    KennelPlace place = new KennelPlace(new Price(0));
                    place.setKennelPlaceId(i);
                    place.setOccupied(false);
                    kennel.addPlace(place);
                }
                saveKennel(kennel);
            }
        } catch (Exception e) {
            System.err.println("Error initializing kennel file:");
            e.printStackTrace();
        }
    }

    public Kennel getKennel() {
        Kennel kennel = new Kennel();
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            if (objects != null && objects.length > 0) {
                for (Object obj : objects) {
                    if (obj instanceof KennelPlace) {
                        kennel.addPlace((KennelPlace) obj);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading kennel file: " + e.getMessage());
            e.printStackTrace();
        }
        return kennel;
    }

    public void saveKennel(Kennel kennel) {
        try {
            ArrayList<KennelPlace> places = kennel.getAllKennelPlaces();
            KennelPlace[] placesArray = places.toArray(new KennelPlace[0]);
            MyFileHandler.writeArrayToBinaryFile(fileName, placesArray);
        } catch (Exception e) {
            System.err.println("Error saving kennel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addKennelPlace(Price price) {
        try {
            Kennel kennel = getKennel();
            KennelPlace newPlace = new KennelPlace(price);

            // Find highest existing ID
            int maxId = 0;
            for (KennelPlace place : kennel.getAllKennelPlaces()) {
                if (place.getKennelPlaceId() > maxId) {
                    maxId = place.getKennelPlaceId();
                }
            }

            // Set new ID and properties
            newPlace.setKennelPlaceId(maxId + 1);
            newPlace.setOccupied(false);

            // Add and save
            kennel.addPlace(newPlace);
            saveKennel(kennel);

            System.out.println("Successfully added kennel place with ID: " + (maxId + 1));
        } catch (Exception e) {
            System.err.println("Error adding kennel place: " + e.getMessage());
            e.printStackTrace();
        }
    }
}