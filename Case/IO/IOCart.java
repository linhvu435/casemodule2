package Case.IO;

import Case.OOP.Acount;
import Case.OOP.Hotel;

import java.io.*;
import java.util.ArrayList;

public class IOCart<E> {
    public void write(File file, ArrayList<E> list)
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
    public  ArrayList<E> read (File file)
    {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<E>) ois.readObject();
        } catch (Exception e) {
            e.fillInStackTrace();
            return new ArrayList();
        }

    }
}
