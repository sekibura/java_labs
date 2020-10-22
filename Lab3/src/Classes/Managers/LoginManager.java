package Classes.Managers;

import Classes.Controller;
import Classes.TypeGroup;
import Classes.User;
import Classes.View;

import javax.jws.soap.SOAPBinding;

public class LoginManager {
    View view;
    Controller controller;
    User user;

    public LoginManager() {
        System.out.println("Login manager was created!");
        user=null;
        view=new View();
        controller=new Controller();
    }

    public void LoginMenu() {
        view.DisplayInfo("Choose option:\n1) Log in\n2) Register\n");
        int input=controller.InputDigit(1,2);
        switch (input){
            case 1:
                LogIn();
                break;
            case 2:
                Registration();
                break;

        }
    }

    private void Registration(){
        view.DisplayInfo("Enter login:");
        String login= controller.InputString();
        view.DisplayInfo("Enter password:");
        String password=controller.InputString();
        view.DisplayInfo("Choose group:\n1) root\n2) user:");
        int group_=controller.InputDigit(1,2);

        switch (group_){
            case 1:
                SetUser(new User(login,password, TypeGroup.root));
                break;
            case 2:
                SetUser(new User(login,password, TypeGroup.user));
                break;
        }


    }
    private void LogIn(){



    }
    private void SetUser(User user_){
        user=user_;
    }
}
