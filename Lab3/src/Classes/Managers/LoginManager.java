package Classes.Managers;

import Classes.*;

import java.util.Vector;

public class LoginManager {
    private Paths paths;
    private View view;
    private Controller controller;
    private User current_user;
    private Vector<User> users;
    private FileManager fileManager;

    public LoginManager(Controller controller_) {
        System.out.println("Login manager was created!");
        users = new Vector<User>(0);
        current_user = null;
        view = new View();
        controller = controller_;
        paths = new Paths();
        fileManager = new FileManager();
    }

    public void LoginMenu() {
        LoadUsers();
        while (getCurrent_user() == null) {
            view.DisplayInfo("Choose option:\n1) Log in\n2) Register\n");
            int input = controller.InputDigit(1, 2);
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
        view.DisplayInfo("Registration:\nEnter login:");
        String login = controller.InputString();
        view.DisplayInfo("Enter password:");
        String password = controller.InputString();
        view.DisplayInfo("Choose group:\n1) root\n2) user:");
        int group_ = controller.InputDigit(1, 2);
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
        SaveUsers();

    }

    private void LogIn() {
        view.DisplayInfo("Enter login:");
        String login = controller.InputString();
        view.DisplayInfo("Enter password:");
        String password = controller.InputString();
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
            view.DisplayInfo("Hello, " + current_user.getLogin() + "!");
        } else {
            view.DisplayInfo("Login error!");
            if(users.size()==0){
                view.DisplayInfo("User base is empty!");
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
        fileManager.<Vector<User>>Save(users, paths.getUsersBasePath());
    }


    public void LoadUsers() {
        SetUsers(fileManager.<Vector<User>>Load(paths.getUsersBasePath()));
    }

    private void SetUsers(Vector<User> users_) {
        if (users_ != null) {
            users = users_;
        }
    }
}
