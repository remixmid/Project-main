package savepackages;

import Model.Kennel;
import Model.KennelPlace;
import Model.Price;
import Utils.MyFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class KennelModelManager {
    private String fileName;

    public KennelModelManager(String fileName) {
        this.fileName = "Model.Kennel.bin";
    }

    public Kennel getKennel() {
        List<Object> kennelArr = new ArrayList<>();
        try {
            kennelArr = Stream.of(MyFileHandler.readArrayFromBinaryFile(this.fileName)).toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Kennel kennel = new Kennel(10);
        int i = 0;
        for (Object obj : kennelArr) {
            if (obj != null) {
                kennel.setKennelPlace((KennelPlace) obj,  i);
            }
            i++;
        }
        return kennel;
    }

    public void editKennel(KennelPlace kennelPlace, int id) {
        try {
            Kennel kennel = getKennel();
            kennel.setKennelPlace(kennelPlace, id);
            saveKennel(kennel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveKennel(Kennel kennel) {
        try {
            MyFileHandler.writeArrayToBinaryFile(this.fileName, kennel.getAllKennelPlaces());
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
