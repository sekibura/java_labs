package Classes;

import Classes.child_classes.Predator;

public class Main {

    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.AddGrass("Travka", 12, 1, false, false);
        forest.AddTree("Berezka", 50, 15, false, "white and black", 20);
        forest.AddHerbivore("Kozel", 2, 40, "Travka");
        Predator tiger = new Predator("Tiger", 50, 4, true);

        forest.<Predator>AddAnimal(tiger);
        forest.PrintAll();
        tiger.ToHunt(forest);
        forest.PrintAll();

    }


}
