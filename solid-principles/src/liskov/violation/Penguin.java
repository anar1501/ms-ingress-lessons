package liskov.violation;

public class Penguin extends Bird{
    @Override
    public void fly() {
        System.out.println("A penguin is trying to fly");//Penguins can't fly
    }
}
