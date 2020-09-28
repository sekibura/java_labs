package Classes.child_classes;

import Classes.Animals;

public class Predator extends Animals {
    private boolean have_claws; // наличие когтей

    public Predator() {
        super();
    }

    public Predator(String name, float weight, int age, boolean have_claws) {
        super(name, age, weight);
        setHave_claws(have_claws);
    }

    public void setHave_claws(boolean have_claws) {
        this.have_claws = have_claws;
    }

    public boolean isHave_claws() {
        return have_claws;
    }
}
