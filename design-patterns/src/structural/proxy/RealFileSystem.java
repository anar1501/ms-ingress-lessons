package structural.proxy;

//Real Subject
public class RealFileSystem implements FileSystem {
    private String filename;

    public RealFileSystem(String filename) {
        this.filename = filename;
    }

    @Override
    public void readFile() {
        System.out.println("File is reading: " + filename);
    }
}

