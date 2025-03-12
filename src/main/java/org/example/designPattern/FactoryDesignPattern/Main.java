package org.example.designPattern.FactoryDesignPattern;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");
        circle.getArea();
    }
}
