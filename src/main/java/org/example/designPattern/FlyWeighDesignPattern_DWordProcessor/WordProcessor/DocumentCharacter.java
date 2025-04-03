package org.example.designPattern.FlyWeighDesignPattern_DWordProcessor.WordProcessor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentCharacter implements ILetter{

    // Intrinsic Data
    Character character;
    String fontName;
    int fontSize;

    @Override
    public void drawCharacter(int row, int col) {
        // draw the object at row and col
        System.out.println("Printing " + character + " at " + row + " " + col);
    }
}
