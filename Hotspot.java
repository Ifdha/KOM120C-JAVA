import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }

    @Override
    public int compareTo(Point other) {
        if (x < other.x || (x == other.x && y < other.y)) {
            return 1;
        } else if (x == other.x && y == other.y) {
            return 0;
        } else {
            return -1;
        }
    }
}

class Points {
    private Set<Point> points = new TreeSet<>();

    public void insertPoint(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point p = new Point(x, y);
        points.add(p);
    }

    public void cetakPoints() {
        System.out.println(points.size());
        for (Point temp : points) {
            if (temp.y > 0) {
                System.out.printf("(%d,%d)", temp.x, temp.y);
            }
        }
        System.out.println();
    }
}

public class Hotspot {
    public static void main(String[] args) {
        Points p = new Points();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            p.insertPoint(scanner);
        }
        p.cetakPoints();
    }
}