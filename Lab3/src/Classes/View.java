package Classes;

public class View {

    public View(){
        System.out.println("Init view");
    }
    public void DisplayInfo(String value){
        System.out.println("************");
        System.out.println(value);
        System.out.println("************");
    }
    public void MainMenu(){
        System.out.println("*** Menu ***");
        System.out.println("1) Add predator");
        System.out.println("2) Add grass");
        System.out.println("3) Add herbivore");
        System.out.println("4) Add tree");
        System.out.println("5) Print all forest");
        System.out.println("6) To hunt");
        System.out.println("7) To eat plants");
        System.out.println("8) Save forest");
        System.out.println("9) Load forest");
        System.out.println("10) Print user settings");
        System.out.println("0) Exit");
    }

    public void MainMenuRoot(){
        System.out.println("*** Menu ***");
        System.out.println("1) Add predator");
        System.out.println("2) Add grass");
        System.out.println("3) Add herbivore");
        System.out.println("4) Add tree");
        System.out.println("5) Print all forest");
        System.out.println("6) To hunt");
        System.out.println("7) To eat plants");
        System.out.println("8) Save forest");
        System.out.println("9) Load forest");
        System.out.println("10) Print user settings");
        System.out.println("0) Exit");
        System.out.println("\n***Root menu***\n");
        System.out.println("11) Debug");
        System.out.println("12) AutoTests");
    }
    public void MainMenuUser(){
        System.out.println("*** Menu ***");
        System.out.println("1) Add predator");
        System.out.println("2) Add grass");
        System.out.println("3) Add herbivore");
        System.out.println("4) Add tree");
        System.out.println("5) Print all forest");
        System.out.println("6) To hunt");
        System.out.println("7) To eat plants");
        System.out.println("8) Save forest");
        System.out.println("9) Load forest");
        System.out.println("10) Print user settings");
        System.out.println("0) Exit");
    }
}
