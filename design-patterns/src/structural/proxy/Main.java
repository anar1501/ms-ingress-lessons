package structural.proxy;

//Client Side
public class Main {
    public static void main(String[] args) {
        FileSystem file = new ProxyFileSystem("example.txt");

        //When the file is read for the first time, the actual object is created
        file.readFile();

        //When the same file is read again, the actual object is not created again.
        file.readFile();
    }
}

