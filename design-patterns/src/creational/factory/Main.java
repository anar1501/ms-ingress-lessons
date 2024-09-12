package creational.factory;

import static creational.factory.ObjectType.Object_A;

public class Main {
    public static void main(String[] args) {
        Object instance = ObjectCreatingFactory.getInstance(Object_A);
        System.out.println(instance.hashCode());
    }
}
