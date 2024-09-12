package creational.factory;


import java.lang.reflect.Constructor;

public abstract class ObjectCreatingFactory {

    public static Object getInstance(ObjectType objectType) {
        try {
            String className = objectType.getObjectClassPath();
            Class<?> getObject = Class.forName(className);
            Constructor<?> constructor = getObject.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
