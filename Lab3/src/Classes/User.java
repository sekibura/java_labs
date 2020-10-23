package Classes;

import java.io.Serializable;

public class User implements Serializable {
    private String Login;
    private String password;
    private TypeGroup group;

    public User(String login_,String password_,TypeGroup group_){
        Login =login_;
        password=password_;
        group=group_;
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
}

