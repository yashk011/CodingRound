package org.example.LLDQuestions.FlyWeighDesignPattern_DWordProcessor.WordProcessor;

public class WordProcessorDemo {
    public static void main(String[] args) {

        /*
        1. The sky is blue.The Tiger Tackles.
        2. Multiple times each character can occur
        T - 4 times
        3. Use Flyweight to create just one instance of T and just use method param for
        locations
         */
        DocumentCharacterFactory documentCharacterFactory = new DocumentCharacterFactory();
        ILetter letter = documentCharacterFactory.createCharacter('T');
        letter.drawCharacter(0,1);

        ILetter letter2 = documentCharacterFactory.createCharacter('T');
        letter.drawCharacter(0,9);

    }
}
