package Classes;

import Classes.Managers.MyLogger;
import Classes.child_classes.Grass;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;
import Classes.child_classes.Tree;
import Classes.Managers.FileManager;


import java.util.Vector;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Forest implements Serializable {
    private final Vector<Plants> plants;
    private final Vector<Animals> animals;
    private Paths paths;
    private final static Logger logger = MyLogger.GetLogger();

    public Forest() {

        plants = new Vector<>(0);
        animals = new Vector<>(0);
        paths = new Paths();
        logger.log(Level.INFO, "New forest was created!");
    }

    public void AddPredator(String name, float weight, int age, boolean have_claws) {
        animals.add(new Predator(name, weight, age, have_claws));
        logger.log(Level.INFO, "New predator was added to forest!");
    }

    public void AddHerbivore(String name, int age, float weight, String preferred_plants) {
        animals.add(new Herbivore(name, age, weight, preferred_plants));
        logger.log(Level.INFO, "New herbivore was added to forest!");
    }


    public void AddTree(String name, int age, float height, boolean haveFruit, String bark_color, float trunk_radius) {
        plants.add(new Tree(name, age, height, haveFruit, bark_color, trunk_radius));
        logger.log(Level.INFO, "New tree was added to forest!");
    }

    public void AddGrass(String name, float height, int age, boolean haveFruit, boolean is_flowers) {
        plants.add(new Grass(name, height, age, haveFruit, is_flowers));
        logger.log(Level.INFO, "New grass was added to forest!");
    }

    public <T> void AddPlant(T plant) {
        plants.add((Plants) plant);
        logger.log(Level.INFO, "New plant was added to the forest.");
    }

    public <T> void AddAnimal(T animal) {
        animals.add((Animals) animal);
        logger.log(Level.INFO, "New animal was added to forest!");
    }

    public Vector<Animals> getAnimals() {
        return animals;
    }

    public Vector<Plants> getPlants() {
        return plants;
    }

    private void SetAnimals(Vector<Animals> value) {
        if (value == null) {
            View.DisplayInfo("Animals base empty!");
        } else {
            try {
                animals.clear();
                animals.addAll(value);
                logger.log(Level.INFO, "Animals vector was update.");
            } catch (Exception e) {
                logger.log(Level.WARNING, "Set animals", e);
            }
        }
    }

    private void SetPlants(Vector<Plants> value) {
        if (value == null) {
            View.DisplayInfo("Plants base empty!");
        } else {
            try {
                plants.clear();
                plants.addAll(value);
                logger.log(Level.INFO, "Plants vector was update.");
            } catch (Exception e) {
                logger.log(Level.WARNING, "Set plants", e);

            }
        }

    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public int getNumberOfPlants() {
        return plants.size();
    }

    public void PrintAll() {
        String value = "";
        if (getNumberOfAnimals() > 0) {

            for (Object a : animals) {
                value += ((Animals) a).ToString() + "\n";
            }
            View.DisplayInfo("Animals:\n" + value);
        } else {
            View.DisplayInfo("No animals.");
        }
        value = "";
        if (getNumberOfPlants() > 0) {
            for (Object a : plants) {
                value += ((Plants) a).ToString() + "\n";
            }
            View.DisplayInfo("Plants:\n" + value);
        } else {
            View.DisplayInfo("No plants.");
        }

    }

    public void SaveForest() {
        FileManager fm = new FileManager();
        fm.<Vector<Plants>>Save(plants, paths.getPlantsBasePath());
        fm.<Vector<Animals>>Save(animals, paths.getAnimalBasePath());
        logger.log(Level.INFO, "Forest was saved.");
    }

    public void LoadForest() {
        FileManager fm = new FileManager();
        SetAnimals(fm.<Vector<Animals>>Load(paths.getAnimalBasePath()));
        SetPlants(fm.<Vector<Plants>>Load(paths.getPlantsBasePath()));
        logger.log(Level.INFO, "Forest was loaded.");
    }

    public void ClearForest(){
        animals.clear();
        plants.clear();
    }
}
