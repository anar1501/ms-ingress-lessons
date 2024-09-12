package creational.factory;

public enum ObjectType {
    Object_A("creational.factory.ObjectA"),
    Object_B("creational.factory.ObjectB");
    String objectClassPath;

    ObjectType(String objectClassPath) {
        this.objectClassPath = objectClassPath;
    }

    public String getObjectClassPath() {
        return objectClassPath;
    }
}