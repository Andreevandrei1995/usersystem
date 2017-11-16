package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Polzovatel;
import system.model.Text;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Repository
/*@XmlType(propOrder = {"polzovatels"})
@XmlRootElement*/
public class UserDao {

    private List<Polzovatel> polzovatels = new ArrayList();

    public UserDao() throws Exception{
        /*polzovatels.add(new Polzovatel("admin","admin"));
        polzovatels.add(new Polzovatel("admin2","admin2"));*/
    }

    public void addText(String login, String text){//Добавить текст пользователю
        for (Polzovatel polz:this.polzovatels
             ) {
            if (polz.getLogin().equals(login)){
                polz.getText().add(new Text(text));
            }
        }
    }

    public String getAllTextPolz(String login){//получить весь текст по пользователю
        String textAll = "";
        for (Polzovatel polz:this.polzovatels
                ) {
            if (polz.getLogin().equals(login)){


                for (Text strochka:polz.getText()
                     ) {
                    textAll = textAll + strochka.getText() + "\n";
                }
            }
        }
        return textAll;
    }

    /*@XmlElement*/
    public List<Polzovatel> getPolzovatels() {
        return this.polzovatels;
    }

    public void addPolzovatel(String login, String password){
        polzovatels.add(new Polzovatel(login,password));
    }
}
