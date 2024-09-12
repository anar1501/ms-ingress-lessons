package structural.decorator;

public class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 2.0;
    }
}