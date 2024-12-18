package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kennel {
    private ArrayList<KennelPlace> kennelPlaces;

    public Kennel() {
        kennelPlaces = new ArrayList<>();
    }

    public ArrayList<KennelPlace> getAllKennelPlaces() {
        return kennelPlaces;
    }

    public void addPlace(KennelPlace place) {
        kennelPlaces.add(place);
    }

    public void addKennelPlace(Price price) {
        kennelPlaces.add(new KennelPlace(price));
    }

    public KennelPlace getKennelPlaceById(int id) {
        for (KennelPlace kennelPlace: kennelPlaces) {
            if (kennelPlace.getKennelPlaceId() == id)
                return kennelPlace;
        }
        return null;
    }

    public void setKennelPlace(KennelPlace kennelPlace, int id) {
        this.sortKennelPlaces();
        kennelPlaces.set(id, kennelPlace);
    }

    public void sortKennelPlaces() {
        kennelPlaces.sort((o1, o2) -> Integer.compare(o1.getKennelPlaceId(), o2.getKennelPlaceId()));
    }

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
