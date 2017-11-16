package system.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType(propOrder = {"text"})
public class Text {

    private String text;

    public Text() {
        this.text = "";
    }

    public Text(String text) {
        this.text = text;
    }

    @XmlElement
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
