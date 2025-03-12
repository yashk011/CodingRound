package org.example.designPattern.FactoryDesignPattern;

import lombok.SneakyThrows;

public class ShapeFactory {

    @SneakyThrows
    public Shape getShape(String shape) {
        if(shape.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        else if(shape.equalsIgnoreCase("Square")) {
            return new Square();
        }
        else {
            throw new Exception("Unknown Excpetion");
        }
    }
}
