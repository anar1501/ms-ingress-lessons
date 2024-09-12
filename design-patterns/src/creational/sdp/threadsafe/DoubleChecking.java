package creational.sdp.threadsafe;

public class DoubleChecking {
    private static DoubleChecking instance;

    private DoubleChecking() {
    }

    public static DoubleChecking getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new DoubleChecking();
                }
            }
        }
        return instance;
    }
}
