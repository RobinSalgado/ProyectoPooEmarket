package user;

import java.util.Date;

public class User {
    private String userID;
    private String user;
    private String password;
    private boolean loginStatus;
    private String registerDate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public User() {
        userID = "";
        password = "";
        loginStatus = false;
        registerDate = "";
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
        loginStatus = false;
        registerDate = "";
    }

    public User(String userID, String password, boolean loginStatus, String registerDate) {
        this.userID = userID;
        this.password = password;
        this.loginStatus = loginStatus;
        this.registerDate = registerDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

}
