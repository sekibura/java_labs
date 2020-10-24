package Classes.Managers;

import Classes.*;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {
    private User current_user;
    private Vector<User> users;

    private final static Logger logger=MyLogger.GetLogger();

    public LoginManager() {
        logger.log(Level.INFO, "Login manager was created!");
        users = new Vector<User>(0);
        current_user = null;
    }

    public void LoginMenu() {
        LoadUsers();
        while (getCurrent_user() == null) {
            View.DisplayInfo("Choose option:\n1) Log in\n2) Register\n");
            int input = Controller.InputDigit(1, 2);
            switch (input) {
                case 1:
                    LogIn();
                    break;
                case 2:
                    Registration();
                    break;

            }
        }
    }

    private void Registration() {
        View.DisplayInfo("Registration:\nEnter login:");
        String login = Controller.InputString();
        View.DisplayInfo("Enter password:");
        String password = Controller.InputString();
        View.DisplayInfo("Choose group:\n1) root\n2) user:");
        int group_ = Controller.InputDigit(1, 2);
        User NewUser = null;
        switch (group_) {
            case 1:
                NewUser = new User(login, password, TypeGroup.root);
                SetCurrentUser(NewUser);
                break;
            case 2:
                NewUser = new User(login, password, TypeGroup.user);
                SetCurrentUser(NewUser);
                break;
        }
        users.add(NewUser);
        logger.log(Level.INFO,"Registration done:"+"<"+login+"> <"+password+">");
        SaveUsers();


    }

    private void LogIn() {
        View.DisplayInfo("Enter login:");
        String login = Controller.InputString();
        View.DisplayInfo("Enter password:");
        String password = Controller.InputString();
        LoadUsers();
        boolean IsLogIn = false;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                SetCurrentUser(user);
                IsLogIn = true;
                break;
            }
        }
        if (IsLogIn) {
            View.DisplayInfo("Hello, " + current_user.getLogin() + "!");
            logger.log(Level.INFO,"Logined "+current_user.getLogin());
        } else {
            View.DisplayInfo("Login error!");
            logger.log(Level.INFO,"Error login: <"+login+ "> <"+password+">");
            if (users.size() == 0) {
                View.DisplayInfo("User base is empty!");
            }
        }
    }

    private void SetCurrentUser(User user_) {
        current_user = user_;
    }

    public User getCurrent_user() {
        return current_user;
    }

    public void SaveUsers() {
        FileManager.<Vector<User>>Save(users, Paths.getUsersBasePath());
    }


    public void LoadUsers() {
        SetUsers(FileManager.<Vector<User>>Load(Paths.getUsersBasePath()));
    }

    private void SetUsers(Vector<User> users_) {
        if (users_ != null) {
            users = users_;
        }
    }
}
