package Classes.Managers;

import Classes.Animals;
import Classes.Forest;
import Classes.Model;
import Classes.View;
import Classes.child_classes.Predator;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testing {
    private boolean IsTesting = false;
    private Model model = null;
    private static final Logger logger = MyLogger.GetLogger();

    public Testing(Model model1) {
        model = model1;
        logger.log(Level.INFO, "Testing created");
    }

    public void ToTest() {
        setIsTesting(true);
//        TOdo
        //тестирование добавления хищника
        TestAddPredator();
//        тестирование добавления травы
        //тестирование добавления млекопитающего
        //тестирование добавления дерева

        setIsTesting(false);
    }

    public boolean isIsTesting() {
        return IsTesting;
    }

    public void setIsTesting(boolean isTesting) {
        IsTesting = isTesting;
    }

    private boolean TestAddPredator() {
        boolean result = true;
        Forest forest = model.GetForest();
        forest.AddAnimal(new Predator());
        Vector<Animals> animals=forest.getAnimals();
        if(!animals.elementAt(0).IsEqual(new Predator())){
            result=false;
        }
        return result;
    }

    public void setModel(Model model) {
        if (model != null) {
            this.model = model;
        } else {
            logger.log(Level.WARNING, "Model is null");
        }

    }
}
