package Classes;

import Classes.Managers.LoginManager;
import Classes.Managers.MyLogger;
import Classes.Managers.Testing;
import sun.rmi.runtime.Log;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {
    Model model = null;
    LoginManager loginManager;
    private final static Logger logger = MyLogger.GetLogger();

    public Controller() {

//        System.out.println("Classes.Controller init");
        logger.log(Level.INFO,"Controller init");
    }


    public void setModel(Model model1) {
        model = model1;
    }

    public void setLoginManager(LoginManager loginManager1) {
        loginManager = loginManager1;
    }

    public void StartWork() {
        if (model != null) {
            loginManager.LoginMenu();
            Testing tester=new Testing(model);
            tester.ToTest();
            while (true) {
                int input = 0;
                if (loginManager.getCurrent_user().getGroup() == TypeGroup.root) {
                    View.MainMenuRoot();
                    input = InputDigit(0, 13);
                } else {
                    View.MainMenuUser();
                    input = InputDigit(0, 11);
                }
                switch (input) {
                    case 1:
                        model.AddPredator();
                        break;
                    case 2:
                        model.AddGrass();
                        break;
                    case 3:
                        model.AddHerbivore();
                        break;
                    case 4:
                        model.AddTree();
                        break;
                    case 5:
                        model.PrintForest();
                        break;
                    case 6:
                        model.ToHunt();
                        break;
                    case 7:
                        model.ToEatGrass();
                        break;
                    case 8:
                        model.SaveForest();
                        break;
                    case 9:
                        model.LoadForest();
                        break;
                    case 10:
                        View.DisplayInfo(loginManager.getCurrent_user().getSettings());
                        break;
                    case 11:
                        model.AddStarterPack();
                        break;
                    case 12:
                        model.SwitchDebug();
                        break;
                    case 13:
//                        View.DisplayInfo("Autotests!");
                        model.SwitchTests();
                        break;
                    case 0:
                        model.SaveForest();
                        logger.log(Level.INFO,"Exit");
                        System.exit(0);
                        break;

                }
            }
        }
    }

    public static int InputDigit(int min, int max) {
        System.out.println("Enter...\n");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        while (!(isInteger(inputValue) && (Integer.parseInt(inputValue) >= min) && (Integer.parseInt(inputValue) <= max))) {
            System.out.println("Input error! Try again:\n");
            inputValue = scanner.nextLine();
        }
        return Integer.parseInt(inputValue);
    }

    public static boolean isInteger(Object object) {
        if (object instanceof Integer) {
            return true;
        } else {
            String string = object.toString();

            try {
                Integer.parseInt(string);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public static String InputString() {
//        System.out.println("Please enter " + message + " .");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        while (inputValue.isEmpty()) {
            View.DisplayInfo("\nEmpty! Try again!\n");
        }
        return inputValue;
    }

    public static float InputFloat(float min, float max) {
        Scanner scanner = new Scanner(System.in);
        float result = min - 1;
        System.out.println("Enter...\n");
        while (result < min || result > max) {
            String inputValue = scanner.nextLine();
            try {
                result = Float.parseFloat(inputValue);
            } catch (Exception a) {
                System.out.println("Error input float:" + a);
            }
            if (result > max || result < min) {
                result = min - 1;
                System.out.println("Input error. Try again!");
            }
        }
        return result;
    }

    public static boolean InputBool() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 (True), or 0 (False).");
        int result = InputDigit(0, 1);
        if (result == 0) {
            return false;
        } else {
            if (result == 1) {
                return true;
            }
        }
        return true;
    }


}
