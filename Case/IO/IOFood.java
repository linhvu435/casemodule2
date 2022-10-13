package Case.IO;

import Case.OOP.Acount;
import Case.OOP.Food;

import java.io.*;
import java.util.ArrayList;

public class IOFood {
    public  void write(File file, ArrayList<Food> list)
    {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public  ArrayList<Food> read (File file)
    {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Food>) ois.readObject();
        } catch (Exception e) {
            e.fillInStackTrace();
            return new ArrayList();
        }

    }
}
