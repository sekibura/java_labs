import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Model model=new Model();
        controller.setModel(model);
        model.setController(controller);
        controller.StartWork();
//        Forest forest = new Forest();
//        forest.AddGrass("Travka", 12, 1, false, false);
//        forest.AddGrass("Oduvanchik", 12, 1, false, true);
//        forest.AddTree("Berezka", 50, 15, false, "white and black", 20);
//        forest.AddHerbivore("Kozel", 2, 40, "Travka");
//        Predator tiger = new Predator("Tiger", 50, 4, true);
//        Herbivore horse= new Herbivore("Horse",3,100,"Travka");
//        forest.<Predator>AddAnimal(tiger);
//        forest.<Herbivore>AddAnimal(horse);
//        forest.PrintAll();
//        tiger.ToHunt(forest);
//        horse.ToEat(forest);
//
//        forest.PrintAll();

    }


}
