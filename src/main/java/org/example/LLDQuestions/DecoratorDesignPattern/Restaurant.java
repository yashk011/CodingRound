package org.example.LLDQuestions.DecoratorDesignPattern;

public class Restaurant {
    public static void main(String[] args) {
        MargerittaPizza margerittaPizza = new MargerittaPizza();
        CheeseTopping cheeseToppingPizza = new CheeseTopping(margerittaPizza);
        ExtraVeggiesTopping extraVeggiesToppingPizza = new ExtraVeggiesTopping(cheeseToppingPizza);

        System.out.println("Cost of Margarita Pizza " + margerittaPizza.cost());
        System.out.println("Final Cost with All Toppings " + extraVeggiesToppingPizza.cost());
    }
}
