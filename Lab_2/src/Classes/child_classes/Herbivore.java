package Classes.child_classes;

import Classes.Animals;

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

    public void setPreferred_plants(String preferred_plants) {
        this.preferred_plants = preferred_plants;
    }

    public String getPreferred_plants() {
        return preferred_plants;
    }
}
