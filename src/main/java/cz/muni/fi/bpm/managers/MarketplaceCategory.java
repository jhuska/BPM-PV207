package cz.muni.fi.bpm.managers;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CategoryId")
@XmlEnum
public enum MarketplaceCategory {

    @XmlEnumValue("1") ELECTRONICS (1, new String[]{"camera", "notebook", "computer", "netbook", "smartphone", "turing"}),
    @XmlEnumValue("2") FURNITURE   (2, new String[]{"chair", "table", "desk", "sofa", "couch", "cabinet", "shelf"}),
    @XmlEnumValue("3") CARS        (3, new String[]{"car", "coupe", "hatchback", "sedan", "brake", "wheel", "velorex"}),
    @XmlEnumValue("4") CLOTHES     (4, new String[]{"shirt", "skirt", "sweater", "trousers", "jumper", "jacket", "poncho"}),
    @XmlEnumValue("5") SPORT       (5, new String[]{"skis", "bike", "bicycle", "snowboard", "javelin"}),
    @XmlEnumValue("6") OTHER       (6, new String[]{""});
    
    private final int id;
    
    private final String name;
    
    private final String[] words;
    
    private MarketplaceCategory(int id, String[] words) {
        this.id = id;
        this.words = words;
        this.name = this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
    
    public int getId() {
        return id;
    }

    public String[] getWords() {
        return words;
    }

    public String getName() {
        return name;
    }
}
