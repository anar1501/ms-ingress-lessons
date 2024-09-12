package structural.bridge;

public class Rectangle extends Shape{
    public Rectangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Rectangle filled with color ");
        color.draw();
    }
}
