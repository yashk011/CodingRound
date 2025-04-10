package org.example.LLDQuestions.DecoratorDesignPattern;

public class ExtraVeggiesTopping extends PizzaToppingDecorator {

    BasePizza basePizza;

    public ExtraVeggiesTopping(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 40;
    }
}
