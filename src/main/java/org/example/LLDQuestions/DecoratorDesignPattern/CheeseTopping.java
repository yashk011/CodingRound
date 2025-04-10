package org.example.LLDQuestions.DecoratorDesignPattern;

public class CheeseTopping extends PizzaToppingDecorator{

    BasePizza basePizza;

    public CheeseTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost()+ 30;
    }
}
