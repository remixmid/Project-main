package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileHandler {
    public static void writeToTextFile(String fileName, String str) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.print(str);
        }
    }

    public static void appendToTextFile(String fileName, String str) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.print(str);
        }
    }

    public static void writeArrayToTextFile(String fileName, String[] str) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            for (int i = 0; i < str.length; i++) {
                writer.print(str[i]);
            }
        }
    }

    public static void appendArrayToTextFile(String fileName, String[] strs) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true))) {
            for (String str : strs) {
                writer.println(str);
            }
        }
    }

    public static String[] readArrayFromTextFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        try(Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        String[] ex = new String[lines.size()];
        return lines.toArray(ex);
    }

    public static String readFromTextFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        String ex;
        try(Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            ex = scanner.nextLine();
        }
        return ex;
    }

    public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            out.writeObject(obj);
        }
    }

    public static void writeArrayToBinaryFile(String fileName, Object[] obj) throws FileNotFoundException, IOException {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            for (int i = 0; i < obj.length; i++) {
                out.writeObject(obj[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object readFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return in.readObject();
        }
    }

    public static Object[] readArrayFromBinaryFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Object> objects = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            while (in.available() > 0) {
                objects.add(in.readObject());
            }
            in.close();
        } catch (EOFException e)
            {
        }
        return objects.toArray();
    }
}
