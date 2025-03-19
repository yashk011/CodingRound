package org.example.designPattern.CompositeDesignPattern_D_File_System.correctWay.arithmeticExpression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Expression implements ArithmeticExpression{

    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    String operation;

    @Override
    public int solve() {
        switch(operation) {
            case "+" :
                return leftExpression.solve() +rightExpression.solve();
            case "-" :
                return leftExpression.solve() - rightExpression.solve();
            case "*" :
                return leftExpression.solve() * rightExpression.solve();
            case "/" :
                return leftExpression.solve() / rightExpression.solve();
        }
        return -1;
    }
}
