package Classes;

import Classes.Managers.MyLogger;

import java.io.Serializable;
import java.util.logging.Logger;

public abstract class Plants implements Serializable {
    private String name;
    private float height;
    private int age;
    private boolean haveFruit;
    private final static Logger logger = MyLogger.GetLogger();

    public Plants() {
        setName("Empty");
        setAge(0);
        setHaveFruit(false);
        setHeight(0);
    }

    public Plants(String name, float height, int age, boolean haveFruit) {
        setName(name);
        setAge(age);
        setHaveFruit(haveFruit);
        setHeight(height);

    }

    //setters----------------------------
    public void setAge(int age) {
        this.age = age;
    }

    public void setHaveFruit(boolean haveFruit) {
        this.haveFruit = haveFruit;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }
    //getters--------------------------------

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHaveFruit() {
        return haveFruit;
    }

    public float getHeight() {
        return height;
    }

    public void print() {
        System.out.println("Class" + getClass());
        System.out.println("Name - " + getName());
        System.out.println("Height - " + getHeight());
        System.out.println("Age- " + getAge());
        System.out.println("Have Fruit? - " + isHaveFruit());
    }

    public String ToString() {
        return "\nClass - " + getClass() + "\nName - " + getName() + "\nHeight - " + getHeight() + "\nAge- " + getAge() + "\nHave Fruit? - " + isHaveFruit();
    }

    public boolean IsEqual(Plants plant) {
        return ((plant.getName().equals(this.getName())) && (plant.getAge() == this.getAge()) && (plant.getHeight() == this.getHeight()) && (plant.isHaveFruit() == this.isHaveFruit()));
    }
}
