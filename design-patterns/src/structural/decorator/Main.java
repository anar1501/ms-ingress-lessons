package structural.decorator;


public class Main {
    public static void main(String[] args) {
        Pizza basicPizza = new BasicPizza();
        System.out.println(basicPizza.getDescription() + " - $" + basicPizza.getCost());
        Pizza deluxePizza = new ExtraCheese(new Pepperoni(new BasicPizza()));
        System.out.println(deluxePizza.getDescription() + " - $" + deluxePizza.getCost());
    }
}
