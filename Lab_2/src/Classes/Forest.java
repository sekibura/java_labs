package Classes;

import Classes.child_classes.Grass;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;
import Classes.child_classes.Tree;


import java.util.Vector;

public class Forest {
    private final Vector<Plants> plants;
    private final Vector<Animals> animals;

    public Forest(){
        plants= new Vector<>(1);
        animals= new Vector<>(1);
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
    public <T> void AddPlant(T plant){
        plants.add((Plants) plant);
    }
    public <T> void AddAnimal(T animal){
        animals.add((Animals) animal);
    }

    public Vector<Animals> getAnimals() {
        return animals;
    }

    public Vector<Plants> getPlants() {
        return plants;
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }
    public int getNumberOfPlants(){
        return plants.size();
    }
    public void PrintAll(){
        if (getNumberOfAnimals()>0) {
            System.out.print("Животные:\n");
            for (Object a:animals){
                ((Animals)a).print();
                System.out.println();
            }
        } else {System.out.println("Животных нет!\n");}

        if (getNumberOfPlants()>0) {
            System.out.print("Растения:\n");
            for (Object a:plants){
                ((Plants)a).print();
                System.out.println();
            }
        } else {System.out.print("Растений нет!\n");}

    }
}
