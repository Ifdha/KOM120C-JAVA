import java.util.Scanner;

interface Shape2D {
    void set(int n, double[] x, double[] y);
    void cetak();
    double keliling();
}

class Poligon implements Shape2D {
    private int n;
    private double[] x;
    private double[] y;

    public void set(int n, double[] x, double[] y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public void cetak() {
        System.out.printf("[%.2f,%.2f]-[%.2f,%.2f]\n", x[0], y[0], x[n-1], y[n-1]);
    }

    public double keliling() {
        double keliling = 0.00;
        for (int i = 0; i < n-1; i++) {
            double dx = x[i+1] - x[i];
            double dy = y[i+1] - y[i];
            keliling += Math.sqrt(dx*dx + dy*dy);
        }
        double dx = x[0] - x[n-1];
        double dy = y[0] - y[n-1];
        keliling += Math.sqrt(dx*dx + dy*dy);
        return keliling;
    }
}

public class Shape2dMain {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = read.nextDouble();
            y[i] = read.nextDouble();
        }
        Shape2D objek = new Poligon();
        objek.set(n, x, y);
        objek.cetak();
        System.out.printf("%.2f\n", objek.keliling());
    }
}