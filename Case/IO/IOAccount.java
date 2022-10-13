package Case.IO;

import Case.OOP.Acount;
import java.io.*;
import java.util.ArrayList;

public class IOAccount {
    public void write(File file, ArrayList<Acount> list)
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
    public  ArrayList<Acount> read (File file)
    {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Acount>) ois.readObject();
        } catch (Exception e) {
            e.fillInStackTrace();
            return new ArrayList();
        }

    }
}
