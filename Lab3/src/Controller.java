import java.util.Scanner;

public class Controller {
    View view;
    Model model;

    public Controller() {
        view = new View();
        System.out.println("Controller init");

    }


    public void setModel(Model model1) {
        model = model1;
    }

    public void StartWork() {
        while (true) {
            view.MainMenu();
            int input = InputDigit(0, 9);
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
                case 0:
                    System.exit(0);
                    break;

            }
        }
    }

    public int InputDigit(int min, int max) {
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

    public String InputString() {
//        System.out.println("Please enter " + message + " .");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return inputValue;
    }

    public float InputFloat(float min, float max) {
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

    public boolean InputBool() {
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
