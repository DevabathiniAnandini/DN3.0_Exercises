// Subject Interface
 interface Image {
    void display();
}

// Real Subject Class
 class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy Class
 class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Test Class
public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from disk
        image1.display();  
        System.out.println("");

        // Image will not be loaded from disk, but will be displayed from cache
        image1.display();  
        System.out.println("");

        // Image will be loaded from disk
        image2.display();  
        System.out.println("");

        // Image will not be loaded from disk, but will be displayed from cache
        image2.display();
    }
}
