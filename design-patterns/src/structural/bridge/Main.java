package structural.bridge;

public class Main {
    public static void main(String[] args) {
        Shape rectangle=new Rectangle(new RedColor());
        Shape circle=new Circle(new GreenColor());
        rectangle.applyColor();
        circle.applyColor();
    }
}
