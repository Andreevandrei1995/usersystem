package system.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType(propOrder = {"login","password","text"})
public class Polzovatel {
    private String login;
    private String password;
    private List<Text> text;


    public Polzovatel(String login, String password) {
        this.login = login;
        this.password = password;
        text = new ArrayList<Text>();
    }

    public Polzovatel(){

    }

    @XmlElement
    public List<Text> getText() {
        return this.text;
    }

    public void setText(List<Text> text) {
        this.text = text;
    }
    @XmlElement
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
