package system2.model;

import system2.dao.Data;

public class User {
    String login;
    String password;
    Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public User() {
        this.data = new Data();
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.data = new Data();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
