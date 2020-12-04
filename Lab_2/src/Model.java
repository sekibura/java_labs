import Classes.Animals;
import Classes.Forest;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;

import java.util.Vector;

public class Model {
    Forest forest ;
    Controller controller;
    View view ;

    public Model(){
        forest=new Forest();
        view=new View();
        System.out.println("Init model");

        forest.AddGrass("Travka", 12, 1, false, false);
        forest.AddGrass("Oduvanchik", 12, 1, false, true);
        forest.AddTree("Berezka", 50, 15, false, "white and black", 20);
        forest.AddHerbivore("Kozel", 2, 40, "Travka");
        Predator tiger = new Predator("Tiger", 50, 4, true);



        Herbivore horse= new Herbivore("Horse",3,100,"Travka");
        forest.<Predator>AddAnimal(tiger);
        forest.<Herbivore>AddAnimal(horse);
    }
    public void setController(Controller controller1){
        controller=controller1;
    }


    public void AddPredator() {
        view.DisplayInfo("Enter predator`s name");
        String name = controller.InputString();
        view.DisplayInfo("Enter predator`s weight");
        float weight = controller.InputFloat(1, 200);
        view.DisplayInfo("Enter predator`s age");
        int age = controller.InputDigit(0, 50);
        view.DisplayInfo("Enter predator`s claws state");
        boolean have_claws = controller.InputBool();
        forest.AddPredator(name, weight, age, have_claws);
    }

    public void AddHerbivore() {
        view.DisplayInfo("Enter herbivore`s name");
        String name = controller.InputString();
        view.DisplayInfo("Enter herbivore`s weight");
        float weight = controller.InputFloat(1, 200);
        view.DisplayInfo("Enter herbivore`s age");
        int age = controller.InputDigit(0, 50);
        view.DisplayInfo("Enter herbivore`s preferred plants");
        String food = controller.InputString();
        forest.AddHerbivore(name, age, weight, food);
    }

    public void AddGrass() {
        view.DisplayInfo("Enter grass` name");
        String name = controller.InputString();
        view.DisplayInfo("Enter grass` height");
        float height = controller.InputFloat(1, 200);
        view.DisplayInfo("Enter grass` age");
        int age = controller.InputDigit(0, 50);
        view.DisplayInfo("Enter grass` fruit state");
        boolean fruit = controller.InputBool();
        view.DisplayInfo("Enter grass` flowers state");
        boolean flowers = controller.InputBool();
        forest.AddGrass(name, height, age, fruit, flowers);
    }

    public void AddTree() {
        view.DisplayInfo("Enter tree`s name");
        String name = controller.InputString();
        view.DisplayInfo("Enter tree`s height");
        float height = controller.InputFloat(1, 200);
        view.DisplayInfo("Enter tree`s age");
        int age = controller.InputDigit(0, 50);
        view.DisplayInfo("Enter tree`s fruit state");
        boolean fruit = controller.InputBool();
        view.DisplayInfo("Enter tree`s bark color");
        String color = controller.InputString();
        view.DisplayInfo("Enter tree`s trunk radius");
        float radius = controller.InputFloat(0, 100);
        forest.AddTree(name, age, height, fruit, color, radius);
    }

    public void ToHunt(){
        Vector<Animals> animals =forest.getAnimals();
        for (Object object: animals){
            if (object.getClass()==Predator.class){
                ((Predator) object).ToHunt(forest);
            }
        }
    }
    public void ToEatGrass(){
        Vector<Animals> animals =forest.getAnimals();
        for (Object object: animals){
            if (object.getClass()== Herbivore.class){
                ((Herbivore) object).ToEat(forest);
            }
        }
    }
    public void PrintForest(){
        forest.PrintAll();
    }

}
