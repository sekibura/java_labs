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

    public boolean Is_flowers() {
        return is_flowers;
    }

    public void setIs_flowers(boolean is_flowers) {
        this.is_flowers = is_flowers;
    }
}
