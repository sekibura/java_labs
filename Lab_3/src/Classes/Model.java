package Classes;

import Classes.Managers.LoginManager;
import Classes.Managers.MyLogger;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private Forest forest;
    private final static Logger logger = MyLogger.GetLogger();
//    Controller controller;
    //View view ;

    public Model() {
        forest = new Forest();
        // view=new View();
//        System.out.println("Init model");
        logger.log(Level.INFO,"Init model.");


    }
//    public void setController(Controller controller1){
//        controller=controller1;
//    }


    public void AddPredator() {

        View.DisplayInfo("Enter predator`s name");
        String name = Controller.InputString();
        View.DisplayInfo("Enter predator`s weight");
        float weight = Controller.InputFloat(1, 200);
        View.DisplayInfo("Enter predator`s age");
        int age = Controller.InputDigit(0, 50);
        View.DisplayInfo("Enter predator`s claws state");
        boolean have_claws = Controller.InputBool();
        forest.AddPredator(name, weight, age, have_claws);
    }

    public void AddHerbivore() {
        View.DisplayInfo("Enter herbivore`s name");
        String name = Controller.InputString();
        View.DisplayInfo("Enter herbivore`s weight");
        float weight = Controller.InputFloat(1, 200);
        View.DisplayInfo("Enter herbivore`s age");
        int age = Controller.InputDigit(0, 50);
        View.DisplayInfo("Enter herbivore`s preferred plants");
        String food = Controller.InputString();
        forest.AddHerbivore(name, age, weight, food);
    }

    public void AddGrass() {
        View.DisplayInfo("Enter grass` name");
        String name = Controller.InputString();
        View.DisplayInfo("Enter grass` height");
        float height = Controller.InputFloat(1, 200);
        View.DisplayInfo("Enter grass` age");
        int age = Controller.InputDigit(0, 50);
        View.DisplayInfo("Enter grass` fruit state");
        boolean fruit = Controller.InputBool();
        View.DisplayInfo("Enter grass` flowers state");
        boolean flowers = Controller.InputBool();
        forest.AddGrass(name, height, age, fruit, flowers);
    }

    public void AddTree() {
        View.DisplayInfo("Enter tree`s name");
        String name = Controller.InputString();
        View.DisplayInfo("Enter tree`s height");
        float height = Controller.InputFloat(1, 200);
        View.DisplayInfo("Enter tree`s age");
        int age = Controller.InputDigit(0, 50);
        View.DisplayInfo("Enter tree`s fruit state");
        boolean fruit = Controller.InputBool();
        View.DisplayInfo("Enter tree`s bark color");
        String color = Controller.InputString();
        View.DisplayInfo("Enter tree`s trunk radius");
        float radius = Controller.InputFloat(0, 100);
        forest.AddTree(name, age, height, fruit, color, radius);
    }

    public void ToHunt() {
        Vector<Animals> animals = forest.getAnimals();
        Predator predator = null;
        for (Object object : animals) {
            if (object.getClass() == Predator.class) {
                predator = (Predator) object;
                break;
                //                ((Predator) object).ToHunt(forest);
            }
        }
        predator.ToHunt(forest);
    }

    public void ToEatGrass() {
        Vector<Animals> animals = forest.getAnimals();
        Herbivore herbivore = null;
        for (Object object : animals) {
            if (object.getClass() == Herbivore.class) {
                herbivore = (Herbivore) object;
//                ((Herbivore) object).ToEat(forest);
            }
        }
        herbivore.ToEat(forest);
    }

    public void PrintForest() {
        forest.PrintAll();
    }

    public void SaveForest() {
        forest.SaveForest();
    }

    public void LoadForest() {
        forest.LoadForest();
    }

    public void SwitchDebug() {
        if (LoginManager.getCurrent_user().isDebugMode()) { // if debug True -> switch to False
            MyLogger.OffLogger();
            LoginManager.getCurrent_user().setDebugMode(false);

        } else {
            MyLogger.OnLogger();
            LoginManager.getCurrent_user().setDebugMode(true);
        }
        LoginManager.SaveUsers();
    }

    public void SwitchTests() {
        if (LoginManager.getCurrent_user().isAutotests()) { // if  True -> switch to False
            //TODO
            //switch autotests
            //
            LoginManager.getCurrent_user().setAutotests(false);
        } else {
            //TODO
            //switch autotests
            //
            LoginManager.getCurrent_user().setAutotests(true);
        }
        LoginManager.SaveUsers();
    }

    public Forest GetForest(){
        return forest;
    }

    public void AddStarterPack(){
        forest.AddGrass("Travka", 12, 1, false, false);
        forest.AddGrass("Oduvanchik", 12, 1, false, true);
        forest.AddTree("Berezka", 50, 15, false, "white and black", 20);
        forest.AddHerbivore("Kozel", 2, 40, "Travka");
        Predator tiger = new Predator("Tiger", 50, 4, true);
        Herbivore horse = new Herbivore("Horse", 3, 100, "Travka");
        forest.<Predator>AddAnimal(tiger);
        forest.<Herbivore>AddAnimal(horse);
    }

}
