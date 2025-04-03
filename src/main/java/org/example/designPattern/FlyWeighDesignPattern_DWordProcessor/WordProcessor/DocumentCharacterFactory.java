package org.example.designPattern.FlyWeighDesignPattern_DWordProcessor.WordProcessor;

import java.util.HashMap;

public class DocumentCharacterFactory {
    HashMap<Character, ILetter> documentCharacterCache;

    public DocumentCharacterFactory() {
        documentCharacterCache = new HashMap<>();
    }

    public ILetter createCharacter(Character ch) {
        if(documentCharacterCache.containsKey(ch))
            return documentCharacterCache.get(ch);
        else {
            ILetter documentCharacter = new DocumentCharacter(ch , "ARIAL", 20);
            documentCharacterCache.put(ch, documentCharacter);
            return documentCharacter;
        }
    }

}
