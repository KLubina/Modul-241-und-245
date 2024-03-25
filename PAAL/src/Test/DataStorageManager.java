package Test;

import java.io.*;
import java.util.*;

public class DataStorageManager {
    private static final String DATA_PATH = "data/";

    public static void saveObjectToFile(Object object, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_PATH + fileName))) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadObjectFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_PATH + fileName))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}