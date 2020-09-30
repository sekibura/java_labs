import java.util.Scanner;

public class Controller {
    View view = new View();
    Model model = new Model();

    public void StartWork() {
        view.MainMenu();
        int input = InputDigit(1, 5);
        switch (input) {

        }
    }

    public int InputDigit(int min, int max) {
        System.out.println("Enter...\n");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        while (isInteger(inputValue) && (Integer.parseInt(inputValue) >= min) && (Integer.parseInt(inputValue) <= max)) {
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
}
