package Classes.Managers;


import java.io.*;
import java.io.FileNotFoundException;
import java.util.logging.*;

public class FileManager {
    private final static Logger logger = MyLogger.GetLogger();

    public FileManager() {
        logger.log(Level.INFO, "FileManager was created");
        //System.out.println("FileManager was created"); // in log!
    }

    public static <T> void Save(T value, String path) {
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
            logger.log(Level.INFO, "The file " + path + " has been written");
        }
    }

    public static <T> T Load(String path) {
        T value = null;
        try {
            FileInputStream fi = new FileInputStream(new File(path));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            value = (T) oi.readObject();
            oi.close();
            fi.close();
            logger.log(Level.INFO, "Loading " + path + " has been done!");
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File " + path + " not found");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error initializing stream ", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    private static boolean CreateFile(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                logger.log(Level.INFO, "File created: " + myObj.getName());
                return true;
            } else {
                logger.log(Level.INFO, "File" + path + "already exists");
                return true;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "An error occurred.", e);
            return false;
        }
    }

}
