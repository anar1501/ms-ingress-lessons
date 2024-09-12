package behavioral.iterator;

import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        ConcreteCollection<String> collection = new ConcreteCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Item: " + item);
        }
    }
}

