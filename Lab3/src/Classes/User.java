package Classes;

import Classes.Managers.MyLogger;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Serializable {
    private String Login;
    private String password;
    private TypeGroup group;
    private boolean DebugMode;
    private final static Logger logger=MyLogger.GetLogger();

    public User(String login_,String password_,TypeGroup group_){
        Login =login_;
        password=password_;
        group=group_;
        DebugMode=true;
        logger.log(Level.INFO,"New user was created.");

    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return password;
    }

    public TypeGroup getGroup() {
        return group;
    }
    private String getGroupString(){
        if(getGroup()==TypeGroup.root){
            return "root";
        }
        else {
            return "user";
        }
    }
    public String getSettings(){
        return "Login:"+getLogin()+"\nPassword:"+getPassword()+"\nGroup:"+getGroupString();
    }

    public void setDebugMode(boolean debugMode) {
        DebugMode = debugMode;
    }

    public boolean isDebugMode() {
        return DebugMode;
    }

}

