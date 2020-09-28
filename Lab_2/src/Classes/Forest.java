package Classes;

import Classes.child_classes.Grass;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;
import Classes.child_classes.Tree;

import java.lang.reflect.Array;
import java.util.Vector;

public class Forest {
    private Vector plants;
    private Vector animals;

    public Forest(){


    }
    public void AddPredator(String name, float weight, int age, boolean have_claws){
        animals.add(new Predator(name,weight,age,have_claws));

    }
    public void AddHerbivore(String name, int age, float weight, String preferred_plants){
        animals.add(new Herbivore(name,age, weight, preferred_plants));

    }
    public void AddTree(String name, int age, float height, boolean haveFruit, String bark_color, float trunk_radius){
        plants.add(new Tree(name,age,height,haveFruit,bark_color,trunk_radius));
    }
    public void AddGrass(String name, float height, int age, boolean haveFruit, boolean is_flowers){
        plants.add(new Grass(name,height,age,haveFruit,is_flowers));
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }
    public int getNumberOfPlants(){
        return plants.size();
    }
}
