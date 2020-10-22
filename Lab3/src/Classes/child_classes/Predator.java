package Classes.child_classes;

import Classes.Animals;
import Classes.Forest;

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
        Vector<Animals> animals=forest.getAnimals();
        Object prey=null;
        boolean isStarve=true;
        for (Object animal : animals) {
            if(((Animals)animal).getWeight()<this.getWeight()) { // if prey have is less
                //animals.remove(animal); // removing prey
                prey=animal;
                System.out.println(((Animals) animal).getName()+" был съеден хищником - "+this.getName());
                isStarve=false;
                break;
            }
        }
        if (isStarve){System.out.println("Жертва не найдена!");}
        animals.remove(prey);
    }


    public void setHave_claws(boolean have_claws) {
        this.have_claws = have_claws;
    }

    public boolean isHave_claws() {
        return have_claws;
    }
}
