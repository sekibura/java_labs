package Classes;

import Classes.Managers.MyLogger;
import Classes.child_classes.Predator;
import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Animals implements Serializable {
    private String name;
    private int age;
    private float weight;
    private final static Logger logger = MyLogger.GetLogger();

    //constructors----------------------------
    public Animals() {

        logger.log(Level.INFO, "New animal created!");
        setAge(0);
        setName("Empty");
        setWeight(0);
    }

    public Animals(String name, int age, float weight) {
        logger.log(Level.INFO, "New animal created!");
        setAge(age);
        setName(name);
        setWeight(weight);
    }

    //setters------------------------------
    public void setName(String value) {
        this.name = value;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public void setWeight(float value) {
        this.weight = value;
    }

    //getters---------------------------
    public float getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //--------------------------------------
    public void print() {
        System.out.println("Class" + getClass());
        System.out.println("Name - " + getName());
        System.out.println("Weight - " + getWeight());
        System.out.println("Age- " + getAge());
    }

    public String ToString() {
        return "\nClass - " + getClass() + "\nName - " + getName() + "\nWeight - " + getWeight() + "\nAge- " + getAge();
    }

    public boolean IsEqual(Animals animal) {
        return ((animal.getWeight() == this.getWeight()) && (animal.getName().equals(this.getName())) && (animal.getAge() == this.getAge()));
    }

}
