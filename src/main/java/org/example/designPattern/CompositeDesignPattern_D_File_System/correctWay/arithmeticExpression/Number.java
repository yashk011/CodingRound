package org.example.designPattern.CompositeDesignPattern_D_File_System.correctWay.arithmeticExpression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Number implements ArithmeticExpression{
    int number;
    @Override
    public int solve() {
        return this.number;
    }
}
