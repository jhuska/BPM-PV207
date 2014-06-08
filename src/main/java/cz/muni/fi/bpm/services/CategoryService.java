package cz.muni.fi.bpm.services;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class CategoryService {

    public MarketplaceCategory suggestCategory(String title, String description) {
        MarketplaceCategory guess = guessCategory(title);
        if(guess == MarketplaceCategory.OTHER) {
            guess = guessCategory(description);
        }
        return guess;
    }
    
    private static MarketplaceCategory guessCategory(String text) {
        List<String> tokens = Arrays.asList(text.toLowerCase().split("[!?,. ]+"));
        for(MarketplaceCategory category : MarketplaceCategory.values()) {
            for(String word : category.getWords()) {
                if(tokens.contains(word)) {
                    return category;
                }
            }
        }
        return MarketplaceCategory.OTHER;
    }
    
}
