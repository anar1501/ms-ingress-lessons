package structural.proxy;

//Proxy Object
public class ProxyFileSystem implements FileSystem {
    private RealFileSystem realFileSystem;
    private String filename;

    public ProxyFileSystem(String filename) {
        this.filename = filename;
    }

    @Override
    public void readFile() {
        if (realFileSystem == null) {
            realFileSystem = new RealFileSystem(filename);
        }
        realFileSystem.readFile();
    }
}

