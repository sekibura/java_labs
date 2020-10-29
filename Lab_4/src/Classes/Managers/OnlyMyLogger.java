package Classes.Managers;

import Classes.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OnlyMyLogger {
    private static int ErrorCount = 0;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void Setup(String NameLogFile) {
//        System.out.println();

        System.out.println("Init OnlyMyLogger");
        try {
            System.setErr(new PrintStream(new FileOutputStream(NameLogFile,true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void log(LogLevel level, String message) {
        switch (level) {
            case INFO:
                System.err.println(dtf.format(LocalDateTime.now())+" - INFO: " + message);
                break;
            case WARNING:
                System.err.println(dtf.format(LocalDateTime.now())+" - WARNING:" + message);
                AddError();
                break;
        }

    }



    private static void AddError(){
        ErrorCount++;
    }
    public static int getErrorCount(){
        return ErrorCount;
    }
    public static void OnExit(){
        log(LogLevel.INFO,"Error in session = "+getErrorCount());
    }


}

