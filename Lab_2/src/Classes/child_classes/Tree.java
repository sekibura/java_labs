package Classes.child_classes;

import Classes.Plants;

public class Tree extends Plants {
    private String bark_color;  // цвет коры
    private float trunk_radius; // радиус ствола
//constructors-----------------------
    public Tree() {
        super();
        setBark_color("None");
        setTrunk_radius(0);
    }

    public Tree(String name, int age, float height, boolean haveFruit, String bark_color, float trunk_radius) {
        super(name, height, age, haveFruit);
        setBark_color(bark_color);
        setTrunk_radius(trunk_radius);
    }
//getters-----------------------------
    public float getTrunk_radius() {
        return trunk_radius;
    }

    public String getBark_color() {
        return bark_color;
    }
//setters----------------------------------------------
    public void setBark_color(String bark_color) {
        this.bark_color = bark_color;
    }

    public void setTrunk_radius(float trunk_radius) {
        this.trunk_radius = trunk_radius;
    }
//-------------------------------------------------------
public void print(){
    System.out.println("Class"+getClass());
    System.out.println("Name - "+getName());
    System.out.println("Height - "+ getHeight());
    System.out.println("Age- "+ getAge());
    System.out.println("Have fruit? - "+isHaveFruit());
    System.out.println("Bark color - "+getBark_color());
    System.out.println("Trunk radius - "+getTrunk_radius());
}
}

