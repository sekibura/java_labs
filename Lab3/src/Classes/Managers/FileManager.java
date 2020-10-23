package Classes.Managers;


import java.io.*;
import java.io.FileNotFoundException;
import java.util.logging.*;

public class FileManager {
    Logger logger;

    public FileManager() {
        logger = MyLogger.GetLogger();
        logger.log(Level.INFO, "FileManager was created");
        //System.out.println("FileManager was created"); // in log!

    }

    public <T> void Save(T value, String path) {
        if (CreateFile(path)) {
            try {
                FileOutputStream f = new FileOutputStream(new File(path));
                ObjectOutputStream o = new ObjectOutputStream(f);
                // Write objects to file
                o.writeObject(value);
                o.close();
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            //System.out.println("The file has been written");
            logger.log(Level.INFO, "The file " + path + " has been written");
        }
    }

    public <T> T Load(String path) {
        T value = null;
        try {

            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            value = (T) oi.readObject();
            oi.close();
            fi.close();
            System.out.println("Loading has been done!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream " + e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }

    private boolean CreateFile(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return true;
            } else {
                System.out.println("File already exists.");
                return true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }

}
