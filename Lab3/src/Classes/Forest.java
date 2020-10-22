package Classes;

import Classes.child_classes.Grass;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;
import Classes.child_classes.Tree;
import Managers.FileManager;


import java.io.File;
import java.util.Vector;
import java.io.Serializable;
public class Forest implements Serializable {
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

    private void SetAnimals(Vector<Animals>value){
        animals.clear();
        animals.addAll(value);
    }
    private void SetPlants(Vector<Plants>value){
        plants.clear();
        plants.addAll(value);
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

    public void SaveForest(){
        FileManager fm=new FileManager();
        fm.<Vector<Plants>>Save(plants,"D:\\институт\\3 КУРС\\Java\\java_labs\\Lab3\\plants");
        fm.<Vector<Animals>>Save(animals,"D:\\институт\\3 КУРС\\Java\\java_labs\\Lab3\\animals");
    }

    public void LoadForest(){
        FileManager fm=new FileManager();
        SetAnimals((Vector<Animals>) fm.<Vector<Animals>>Load("D:\\институт\\3 КУРС\\Java\\java_labs\\Lab3\\animals"));
        SetPlants((Vector<Plants>) fm.<Vector<Plants>>Load("D:\\институт\\3 КУРС\\Java\\java_labs\\Lab3\\plants"));
    }
}
