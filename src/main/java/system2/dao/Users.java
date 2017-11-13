package system2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.annotation.ExceptionProxy;
import system2.model.Text;
import system2.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
@XmlType(propOrder = {"users"})//порядок следования элементов
@XmlRootElement
public class Users {


    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Users() {
        this.users = new ArrayList<User>();
        User user1 = new User("1","123");
        User user2 = new User("2","123");

        this.users.add(user1);
        this.users.add(user2);
    }

    public boolean check_user(String login, String password) {
        for (User user : this.users
                ) {
            if ((user.getLogin().equals(login)) & (user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public void addText(String login, Text text) throws Exception {
        b:
        for (User user : this.users
                ) {
            if (user.getLogin().equals(login)) {
                user.getData().add(text);
                break b;
            }
        }
        Marshal marshal = new Marshal();
        marshal.marshallExample(this);
    }

    public List<Text> getListText(String login) throws Exception {
        Marshal marshal = new Marshal();
        marshal.unmarshall();
        this.users = marshal.users.users;
        for (User user : this.users
                ) {
            if (user.getLogin().equals(login)) {
                return user.getData().getListText();
            }
        }
        return new ArrayList<Text>();
    }
}

class Marshal{
    Users users;
//
    public void marshallExample(Object object)throws Exception{
        JAXBContext context=JAXBContext.newInstance(Users.class);
        Marshaller marshaller=context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(object ,    new File("D:\\txt.xml"));
        }

    public void unmarshall()throws Exception{
        JAXBContext context=JAXBContext.newInstance(Users.class);
        Unmarshaller un=context.createUnmarshaller();
        this.users = (Users)un.unmarshal(new File("D:\\txt.xml"));
        }
}
