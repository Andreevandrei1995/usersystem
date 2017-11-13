package system2.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Text {

    String text;

    public void setText(String text) {
        this.text = text;
    }

    public Text(){

    }

    public String getText() {
        return this.text;
    }
}
