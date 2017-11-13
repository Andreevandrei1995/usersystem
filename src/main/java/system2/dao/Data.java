package system2.dao;

import org.springframework.stereotype.Repository;
import system2.model.Text;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Data {

    List<Text> listText;

    public Data() {
        listText = new ArrayList();
    }


    public List<Text> getListText() {
        return listText;
    }

    public void setListText(List<Text> listText) {
        this.listText = listText;
    }

    public void add(Text text){
        if (check(text.getText()))
        this.listText.add(text);
    }

    public boolean check(String string) {
        Matcher mat;
        Pattern pat;
        pat = Pattern.compile("[^{}:_;]+");
        mat = pat.matcher(string);
        return mat.matches() ;
    }
}
