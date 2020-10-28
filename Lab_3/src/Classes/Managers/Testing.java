package Classes.Managers;

import Classes.*;
import Classes.child_classes.Grass;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;
import Classes.child_classes.Tree;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing {
    private static boolean IsTesting = false;
    private Model model = null;
    private static final Logger logger = MyLogger.GetLogger();

    public Testing(Model model1) {
        model = model1;
        logger.log(Level.INFO, "Testing created");
    }

    public void ToTest() {
        if (LoginManager.getCurrent_user().isAutotests()) {

            setIsTesting(true);
//  TOdo
    //тестирование добавления хищника
//            TestAddPredator();
////        тестирование добавления травы
//            TestAddGrass();
//            //тестирование добавления млекопитающего
//            TestAddHerbivore();
//            //тестирование добавления дерева
//            TestAddTree();
//            //To hunt
//            TestToHunt();
//            // To eat plant
//            TestToEat();

            View.DisplayTestInfo("AddPredator - " + TestAddPredator() + "\nAddGrass - " + TestAddGrass() + "\nAddHerbivore - " + TestAddHerbivore() + "\nToHunt - " + TestToHunt() + "\nToEat - " + TestToEat());
            model.GetForest().ClearForest();
            setIsTesting(false);
        }
    }

    public static boolean isIsTesting() {
        return IsTesting;
    }

    public static void setIsTesting(boolean isTesting) {
        IsTesting = isTesting;
    }

    private boolean TestAddPredator() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddAnimal(new Predator());
        Vector<Animals> animals = forest.getAnimals();
//        View.DisplayInfo(animals.elementAt(0).ToString());
        if (!animals.elementAt(0).IsEqual(new Predator())) {
            result = false;
        }
        logger.log(Level.INFO, "Test AddPredator - " + result);
        forest.ClearForest();
        return result;
    }

    private boolean TestAddGrass() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddPlant(new Grass());
        Vector<Plants> plants = forest.getPlants();
//        View.DisplayInfo(plants.elementAt(0).ToString());
        if (!plants.elementAt(0).IsEqual(new Grass())) {
            result = false;
        }
        logger.log(Level.INFO, "Test AddGrass - " + result);
        forest.ClearForest();
        return result;
    }

    private boolean TestAddHerbivore() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddAnimal(new Herbivore());
        Vector<Animals> animals = forest.getAnimals();
//        View.DisplayInfo(plants.elementAt(0).ToString());
        if (!animals.elementAt(0).IsEqual(new Herbivore())) {
            result = false;
        }
        logger.log(Level.INFO, "Test AddHerbivore - " + result);
        forest.ClearForest();
        return result;
    }

    private boolean TestAddTree() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddPlant(new Tree());
        Vector<Plants> plants = forest.getPlants();
//        View.DisplayInfo(plants.elementAt(0).ToString());
        if (!plants.elementAt(0).IsEqual(new Tree())) {
            result = false;
        }
        logger.log(Level.INFO, "Test AddTree - " + result);
        forest.ClearForest();
        return result;
    }

    private boolean TestToHunt() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddAnimal(new Predator("Predator", 100, 100, true));
        forest.AddAnimal(new Predator("Prey", 10, 10, false));
        Vector<Animals> animals = forest.getAnimals();
        model.ToHunt();
//        View.DisplayInfo(plants.elementAt(0).ToString());
        if (!animals.elementAt(0).IsEqual(new Predator("Predator", 100, 100, true)) && (animals.size() != 1)) {
            result = false;
        }
        logger.log(Level.INFO, "Test ToHunt - " + result);
        forest.ClearForest();

        return result;
    }

    private boolean TestToEat() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddAnimal(new Herbivore("Horse", 100, 100, "Travka"));
        forest.AddPlant(new Grass("NotTravka", 10, 10, false, false));
        forest.AddPlant(new Grass("Travka", 10, 10, false, false));
        Vector<Plants> plants = forest.getPlants();
        model.ToEatGrass();
//        View.DisplayInfo(plants.elementAt(0).ToString());
        if (!plants.elementAt(0).IsEqual(new Grass("NotTravka", 10, 10, false, false)) && !(plants.size() == 1)) {
            result = false;
        }
        logger.log(Level.INFO, "Test Eat Grass - " + result);
        forest.ClearForest();

        return result;
    }

    public void setModel(Model model) {
        if (model != null) {
            this.model = model;
        } else {
            logger.log(Level.WARNING, "Model is null");
        }

    }

}
