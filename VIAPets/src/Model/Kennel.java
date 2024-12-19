package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kennel {
    private ArrayList<KennelPlace> kennelPlaces;

    // Constructor to initialize the kennel places list
    public Kennel() {
        kennelPlaces = new ArrayList<>();
    }

    // Returns all kennel places, sorted by ID
    public ArrayList<KennelPlace> getAllKennelPlaces() {
        sortKennelPlaces();
        return kennelPlaces;
    }

    // Adds a new kennel place to the list
    public void addPlace(KennelPlace place) {
        kennelPlaces.add(place);
    }

    // Adds a new kennel place with a given price
    public void addKennelPlace(Price price) {
        kennelPlaces.add(new KennelPlace(price));
    }

    // Returns a kennel place by its ID, or null if not found
    public KennelPlace getKennelPlaceById(int id) {
        for (KennelPlace kennelPlace: kennelPlaces) {
            if (kennelPlace.getKennelPlaceId() == id)
                return kennelPlace;
        }
        return null;
    }

    // Sets a kennel place at a specific index after sorting the list
    public void setKennelPlace(KennelPlace kennelPlace, int id) {
        this.sortKennelPlaces();
        kennelPlaces.set(id, kennelPlace);
    }

    // Sorts the kennel places by their ID in ascending order
    public void sortKennelPlaces() {
        kennelPlaces.sort((o1, o2) -> Integer.compare(o1.getKennelPlaceId(), o2.getKennelPlaceId()));
    }

    // Converts the list of kennel places to a string representation
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (KennelPlace kennelPlace: getAllKennelPlaces()) {
            stringBuilder.append(kennelPlace.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
