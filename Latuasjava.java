interface Hello {
    void show();
    }
    public class Latuasjava {
    static Hello h = new Hello() {
    public void show() { System.out.println("Class Tanpa Nama"); }
    };
    public static void main(String[] args) {
    h.show();
    }
    }