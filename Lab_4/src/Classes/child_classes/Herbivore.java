package Classes.child_classes;

import Classes.Animals;
import Classes.Forest;
import Classes.Plants;
import Classes.View;

import java.io.Serializable;
import java.util.Vector;

//травоядное
public class Herbivore extends Animals implements Serializable {
    private String preferred_plants;

    public Herbivore() {
        super();
        setPreferred_plants("none");
    }

    public Herbivore(String name, int age, float weight, String preferred_plants) {
        super(name, age, weight);
        setPreferred_plants(preferred_plants);
    }

    public void print() {
        System.out.println("Class" + getClass());
        System.out.println("Name - " + getName());
        System.out.println("Weight - " + getWeight());
        System.out.println("Age- " + getAge());
        System.out.println("Preferred plants - " + getPreferred_plants());
    }

    public void ToEat(Forest forest) {
        Vector<Plants> plants = forest.getPlants();
        Object prey = null;
        boolean isStarve = true;
        for (Object plant : plants) {
            if (((Plants) plant).getName().equals(this.getPreferred_plants())) {
                //plants.remove(plant); // removing plant
                prey = plant;
                View.DisplayInfo(((Plants) plant).getName() + " was eaten by - " + this.getName());
//                System.out.println(((Plants) plant).getName()+" was eaten by - "+this.getName());
                isStarve = false;
                break;
            }
        }
        if (isStarve) {
            System.out.println("No food!");
        }
        plants.remove(prey);
    }

    public void setPreferred_plants(String preferred_plants) {
        this.preferred_plants = preferred_plants;
    }

    public String getPreferred_plants() {
        return preferred_plants;
    }

    public String ToString() {
        return "\nClass - " + getClass() + "\nName - " + getName() + "\nWeight - " + getWeight() + "\nAge- " + getAge() + "\nPreferred plants - " + getPreferred_plants();
    }

    public boolean IsEqual(Herbivore herbivore){
            return ((herbivore.getWeight() == this.getWeight()) && (herbivore.getName().equals(this.getName())) && (herbivore.getAge() == this.getAge()) && (herbivore.getPreferred_plants().equals(this.getPreferred_plants())));

    }
}
