package Classes;

import Classes.Managers.*;
import Classes.child_classes.Herbivore;
import Classes.child_classes.Predator;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = MyLogger.Setup();
        Controller controller = new Controller();
        Model model = new Model();
        controller.setModel(model);
        LoginManager loginManager = new LoginManager();
        controller.setLoginManager(loginManager);

        model.Lab4();
//        controller.StartWork();
    }


}
