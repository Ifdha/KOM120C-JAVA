import java.util.Scanner;

abstract class Shape {
    public abstract double getKeliling();
}

class Rectangle extends Shape {
    private double panjang;
    private double lebar;

    Rectangle(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double getKeliling() {
        return 2 * (panjang + lebar);
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getKeliling() {
        return 2 * Math.PI * radius;
    }
}

public class PagarTanah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Shape[] shapes = new Shape[n];
        double totalKeliling = 0;

        for (int i = 0; i < n; i++) {
            int shapeType = scanner.nextInt();
            double param1 = scanner.nextDouble();

            if (shapeType == 0) {
                double param2 = scanner.nextDouble();
                shapes[i] = new Rectangle(param1, param2);
            } else {
                shapes[i] = new Circle(param1);
            }

            totalKeliling += shapes[i].getKeliling();
        }

        double averageKeliling = totalKeliling / n;

        double sumPagar = 0;
        for (Shape shape : shapes) {
            if (shape.getKeliling() > averageKeliling) {
                sumPagar += shape.getKeliling();
            }
        }

        System.out.printf("%.2f\n", sumPagar);
    }
}
