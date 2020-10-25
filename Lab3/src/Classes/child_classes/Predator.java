package Classes.child_classes;

import Classes.Animals;
import Classes.Forest;
import Classes.View;

import java.io.Serializable;
import java.util.Vector;

public class Predator extends Animals implements Serializable {
    private boolean have_claws; // наличие когтей

    public Predator() {
        super();
    }

    public Predator(String name, float weight, int age, boolean have_claws) {
        super(name, age, weight);
        setHave_claws(have_claws);
    }

    public void print() {
        System.out.println("Class: " + getClass());
        System.out.println("Name - " + getName());
        System.out.println("Weight - " + getWeight());
        System.out.println("Age- " + getAge());
        System.out.println("Have claws? - " + isHave_claws());
    }

    public void ToHunt(Forest forest) {
        Vector<Animals> animals = forest.getAnimals();
        Object prey = null;
        boolean isStarve = true;
        for (Object animal : animals) {
            if (((Animals) animal).getWeight() < this.getWeight()) { // if prey have is less
                //animals.remove(animal); // removing prey
                prey = animal;
//                System.out.println(((Animals) animal).getName()+" was eaten by - "+this.getName());
                View.DisplayInfo(((Animals) animal).getName() + " was eaten by - " + this.getName());
                isStarve = false;
                break;
            }
        }
        if (isStarve) {
            View.DisplayInfo("No food!");
//            System.out.println("No food!");
        }
        animals.remove(prey);
    }


    public void setHave_claws(boolean have_claws) {
        this.have_claws = have_claws;
    }

    public boolean isHave_claws() {
        return have_claws;
    }

    public String ToString() {
        return "\nClass - " + getClass() + "\nName - " + getName() + "\nWeight - " + getWeight() + "\nAge- " + getAge() + "\nHave claws? - " + isHave_claws();
    }

    public boolean IsEqual(Predator predator) {
        return ((predator.getWeight() == this.getWeight()) && (predator.getName().equals(this.getName())) && (predator.getAge() == this.getAge()) && (predator.isHave_claws() == this.isHave_claws()));
    }
}
