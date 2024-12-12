package Model;

public class Kennel {
    private KennelPlace[] kennelPlaces;
    private int amountOfPlaces;

    public Kennel(int amountOfPlaces) {
        this.amountOfPlaces = amountOfPlaces;
        kennelPlaces = new KennelPlace[amountOfPlaces];
    }

    public KennelPlace[] getAllKennelPlaces() {
        return kennelPlaces;
    }

    public int getAmountOfPlaces() {
        return amountOfPlaces;
    }

    public void addKennelPlace(Price price) {
        amountOfPlaces++;
        KennelPlace[] newKennelPlaces = new KennelPlace[kennelPlaces.length + 1];
        int i = 0;
        for (KennelPlace kennelPlace : kennelPlaces) {
            newKennelPlaces[i] = kennelPlace;
            i++;
        }
        newKennelPlaces[amountOfPlaces - 1] = new KennelPlace(price);
        this.kennelPlaces = newKennelPlaces;
    }

    public KennelPlace getKennelPlaceById(int id) {
        for (KennelPlace kennelPlace: kennelPlaces) {
            if (kennelPlace.getKennelPlaceId() == id)
                return kennelPlace;
        }
        return null;
    }

    public void setKennelPlace(KennelPlace kennelPlace, int id) {
        kennelPlaces[id] = kennelPlace;
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
