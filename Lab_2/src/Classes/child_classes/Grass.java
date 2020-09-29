package Classes.child_classes;

import Classes.Plants;

public class Grass extends Plants {
    private boolean is_flowers;

    public Grass() {
        super();
    }

    public Grass(String name, float height, int age, boolean haveFruit, boolean is_flowers) {
        super(name, height, age, haveFruit);
        setIs_flowers(is_flowers);
    }
    public void print(){
        System.out.println("Class"+getClass());
        System.out.println("Name - "+getName());
        System.out.println("Height - "+ getHeight());
        System.out.println("Age- "+ getAge());
        System.out.println("Have Fruit? - "+ isHaveFruit());
        System.out.println("Is flower? - "+ is_flowers());
    }

    public boolean is_flowers() {
        return is_flowers;
    }

    public void setIs_flowers(boolean is_flowers) {
        this.is_flowers = is_flowers;
    }
}
