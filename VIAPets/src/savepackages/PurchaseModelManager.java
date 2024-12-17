package savepackages;

import Model.Purchase;
import Model.PurchaseList;
import Utils.MyFileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PurchaseModelManager {

    private String fileName;

    public PurchaseModelManager(String fileName) {
        this.fileName = "Purchases.bin";
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PurchaseList getPurchases() {
        PurchaseList purchaseList = new PurchaseList();
        try {
            Object[] objects = MyFileHandler.readArrayFromBinaryFile(fileName);
            for (Object obj : objects) {
                purchaseList.addPurchase((Purchase) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return purchaseList;
    }

    public void addPurchase(Purchase purchase) {
        try {
            PurchaseList purchaseList = getPurchases();
            purchaseList.addPurchase(purchase);
            savePurchases(purchaseList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savePurchases(PurchaseList purchaseList) {
        try {
            MyFileHandler.writeArrayToBinaryFile(this.fileName, purchaseList.getPurchases().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
