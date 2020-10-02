package Classes.child_classes;

import Classes.Animals;
import Classes.Forest;
import Classes.Plants;

import java.util.Vector;

//травоядное
public class Herbivore extends Animals {
    private String preferred_plants;

    public Herbivore() {
        super();
    }

    public Herbivore(String name, int age, float weight, String preferred_plants) {
        super(name, age, weight);
        setPreferred_plants(preferred_plants);
    }

    public void print(){
        System.out.println("Class"+getClass());
        System.out.println("Name - "+getName());
        System.out.println("Weight - "+ getWeight());
        System.out.println("Age- "+ getAge());
        System.out.println("Preferred plants - "+getPreferred_plants());
    }

    public void ToEat(Forest forest) {
        Vector<Plants> plants=forest.getPlants();
        Object prey=null;
        boolean isStarve=true;
        for (Object plant : plants) {
            if(((Plants)plant).getName().equals(this.getPreferred_plants())) {
                //plants.remove(plant); // removing plant
                prey=plant;
                System.out.println(((Plants) plant).getName()+" был съеден травоядным - "+this.getName());
                isStarve=false;
                break;
            }
        }
        if (isStarve){System.out.println("Еды не найдено!");}
        plants.remove(prey);
    }

    public void setPreferred_plants(String preferred_plants) {
        this.preferred_plants = preferred_plants;
    }

    public String getPreferred_plants() {
        return preferred_plants;
    }
}
