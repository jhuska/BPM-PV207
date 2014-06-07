package cz.muni.fi.bpm.managers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public enum MarketplaceCategory {

    ELECTRONICS (1, new String[]{"camera", "notebook", "computer", "netbook", "smartphone", "turing"}),
    FURNITURE   (2, new String[]{"chair", "table", "desk", "sofa", "couch", "cabinet", "shelf"}),
    CARS        (3, new String[]{"car", "coupe", "hatchback", "sedan", "brake", "wheel", "velorex"}),
    CLOTHES     (4, new String[]{"shirt", "skirt", "sweater", "trousers", "jumper", "jacket", "poncho"}),
    SPORT       (5, new String[]{"skis", "bike", "bicycle", "snowboard", "javelin"}),
    OTHER       (6, new String[]{""});
    
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
