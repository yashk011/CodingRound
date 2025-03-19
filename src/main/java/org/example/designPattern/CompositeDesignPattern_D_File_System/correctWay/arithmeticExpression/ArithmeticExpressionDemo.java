package org.example.designPattern.CompositeDesignPattern_D_File_System.correctWay.arithmeticExpression;

public class ArithmeticExpressionDemo {

    public static void main(String[] args) {

        ArithmeticExpression number1 = new Number(10);
        ArithmeticExpression number2 =  new Number(20);
        ArithmeticExpression number3 = new Number(5);
        ArithmeticExpression expression = new Expression(number1, number2, "+");
        ArithmeticExpression finalExpression = new Expression(expression,  number3,"/");

        System.out.println("Final Value = " + finalExpression.solve());

    }
}
