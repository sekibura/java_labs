package Classes;

import Classes.Managers.LogLevel;
import Classes.Managers.LoginManager;
import Classes.Managers.MyLogger;
import Classes.Managers.OnlyMyLogger;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private Forest forest;
    private final static Logger logger = MyLogger.GetLogger();


    public Model() {
        forest = new Forest();
        logger.log(Level.INFO, "Init model.");
    }


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
            LoginManager.getCurrent_user().setAutotests(false);
        } else {
            LoginManager.getCurrent_user().setAutotests(true);
        }
        LoginManager.SaveUsers();
    }

    public Forest GetForest() {
        return forest;
    }

    public void AddStarterPack() {
        forest.AddGrass("Travka", 12, 1, false, false);
        forest.AddGrass("Oduvanchik", 12, 1, false, true);
        forest.AddTree("Berezka", 50, 15, false, "white and black", 20);
        forest.AddHerbivore("Kozel", 2, 40, "Travka");
        Predator tiger = new Predator("Tiger", 50, 4, true);
        Herbivore horse = new Herbivore("Horse", 3, 100, "Travka");
        forest.<Predator>AddAnimal(tiger);
        forest.<Herbivore>AddAnimal(horse);
    }

    // Lab 4______________________________________________________________________

    public void Lab4() {
        MyLogger.OffLogger();
//        OnlyMyLogger.Setup("Log.txt");
        ArrayList<Forest> forestArrayList = new ArrayList<Forest>();
        LinkedList<Forest> forestLinkedList = new LinkedList<Forest>();
        InitCollections(forestArrayList, forestLinkedList, 10, 2);
        RemoveRandom(forestArrayList, forestLinkedList);
        forestArrayList=new ArrayList<Forest>();
        forestLinkedList=new LinkedList<Forest>();
        InitCollections(forestArrayList, forestLinkedList, 100, 2);
        RemoveRandom(forestArrayList, forestLinkedList);
        forestArrayList = new ArrayList<Forest>();
        forestLinkedList = new LinkedList<Forest>();
        InitCollections(forestArrayList, forestLinkedList, 1000, 2);
        RemoveRandom(forestArrayList, forestLinkedList);
        forestArrayList = new ArrayList<Forest>();
        forestLinkedList = new LinkedList<Forest>();
        InitCollections(forestArrayList, forestLinkedList, 10000, 2);
        RemoveRandom(forestArrayList, forestLinkedList);
        forestArrayList = new ArrayList<Forest>();
        forestLinkedList = new LinkedList<Forest>();
        InitCollections(forestArrayList, forestLinkedList, 100000, 2);
        RemoveRandom(forestArrayList, forestLinkedList);
        forestArrayList = new ArrayList<Forest>();
        forestLinkedList = new LinkedList<Forest>();
    }

    private void InitCollections(ArrayList<Forest> forestArrayList, LinkedList<Forest> forestLinkedList, int CollectionSize, int ForestSize) {
        OnlyMyLogger.Setup("Log" + CollectionSize + ".txt");
        ArrayList<Long> times = new ArrayList<Long>();
        OnlyMyLogger.log(LogLevel.INFO, "Init collection ArrayLit - " + CollectionSize);
//        Long startTime_ = System.currentTimeMillis();
        for (int i = 0; i < CollectionSize; i++) {
            Forest newForest = new Forest();
            newForest.RandomForest(ForestSize);
            Long startTime = System.nanoTime();
            forestArrayList.add(newForest);
            Long endTime = System.nanoTime() - startTime;
            times.add(i, endTime);
            OnlyMyLogger.log(LogLevel.INFO, "ADD, " + i + " = " + endTime);
        }
        OnlyMyLogger.log(LogLevel.INFO, "END ADDx" + CollectionSize + " = " + (Sum(times)) + " ns = " + ((float) Sum(times) / 1000000) + "ms");
        OnlyMyLogger.log(LogLevel.INFO, "Average time = " + (Sum(times) / CollectionSize) + " ns = " + (((float) (Sum(times) / CollectionSize)) / 1000000) + "ms");

        OnlyMyLogger.log(LogLevel.INFO, "Init collection LinkedList - " + CollectionSize);
        times.clear();
//        startTime_ = System.currentTimeMillis();
        for (int i = 0; i < CollectionSize; i++) {
            Forest newForest = new Forest();
            newForest.RandomForest(ForestSize);
            Long startTime = System.nanoTime();
            forestLinkedList.add(newForest);
            Long endTime = System.nanoTime() - startTime;
            times.add(i, endTime);
            OnlyMyLogger.log(LogLevel.INFO, "ADD, " + i + " = " + endTime);
        }
        OnlyMyLogger.log(LogLevel.INFO, "END ADDx" + CollectionSize + " = " + (Sum(times)) + " ns = " + ((float) Sum(times) / 1000000) + "ms");
        OnlyMyLogger.log(LogLevel.INFO, "Average time = " + (Sum(times) / CollectionSize) + " ns = " + (((float) (Sum(times) / CollectionSize)) / 1000000) + "ms");

    }

    private void RemoveRandom(ArrayList<Forest> forestArrayList, LinkedList<Forest> forestLinkedList) {
        OnlyMyLogger.Setup("Log" + forestArrayList.size() + ".txt");
        int first_size=forestArrayList.size();
        ArrayList<Long> times=new ArrayList<Long>();
        OnlyMyLogger.log(LogLevel.INFO, "Remove 10% elements from ArrayLit with size = " + first_size);
        if ((first_size * 0.1) > 0 && ((first_size * 0.1) % 1 == 0)) {
            for (int i = 0; i < first_size * 0.1; i++) {
                Long startTime = System.nanoTime();
                forestArrayList.remove(Controller.getRandomNumberInRange(0, forestArrayList.size()-1));
                Long endTime = System.nanoTime() - startTime;
                times.add(endTime);
                OnlyMyLogger.log(LogLevel.INFO, "remove, " + i + " = " + endTime);
            }
            OnlyMyLogger.log(LogLevel.INFO, "END REMOVEx" + (first_size * 0.1) + " = " + (Sum(times)) + " ns = " + ((float) Sum(times) / 1000000) + "ms");
            OnlyMyLogger.log(LogLevel.INFO, "Average time = " + (Sum(times) / (first_size * 0.1)) + " ns = " + (((float) (Sum(times) / (first_size * 0.1))) / 1000000) + "ms");
        }

        first_size=forestLinkedList.size();
        times.clear();
        OnlyMyLogger.log(LogLevel.INFO, "Remove 10% elements from LinkedList with size = " + first_size);
        if ((first_size * 0.1) > 0 && ((first_size * 0.1) % 1 == 0)) {
            for (int i = 0; i < first_size * 0.1; i++) {
                Long startTime = System.nanoTime();
                forestLinkedList.remove(Controller.getRandomNumberInRange(0, forestLinkedList.size()-1));
                Long endTime = System.nanoTime() - startTime;
                times.add(endTime);
                OnlyMyLogger.log(LogLevel.INFO, "remove, " + i + " = " + endTime);
            }
            OnlyMyLogger.log(LogLevel.INFO, "END REMOVEx" + (first_size * 0.1) + " = " + (Sum(times)) + " ns = " + ((float) Sum(times) / 1000000) + "ms");
            OnlyMyLogger.log(LogLevel.INFO, "Average time = " + (Sum(times) / (first_size * 0.1)) + " ns = " + (((float) (Sum(times) / (first_size * 0.1))) / 1000000) + "ms");
        }
    }

    private Long Sum(ArrayList<Long> list) {
        Long sum = Long.valueOf(0);
        for (Long d : list)
            sum += d;
        return sum;
    }

}
