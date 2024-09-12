package creational.prototype;

public class Main {
    public static void main(String[] args) {
        Shape circlePrototype = new Circle(10);
        Shape clonedCircle = circlePrototype.clone();
        clonedCircle.draw();

        Shape rectanglePrototype = new Rectangle(20, 30);
        Shape clonedRectangle = rectanglePrototype.clone();
        clonedRectangle.draw();
    }
}
