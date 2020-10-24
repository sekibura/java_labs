package Classes.Managers;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Logger Setup() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        try {
            FileHandler fileHandler = new FileHandler("myLogger.log",true);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
    public static Logger GetLogger(){
        return logger;
    }

    public static void OffLogger(){
        logger.setLevel(Level.OFF);
    }
    public static void OnLogger(){
        Setup();
    }



}
