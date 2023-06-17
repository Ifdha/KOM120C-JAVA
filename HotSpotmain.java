import java.util.*;
import java.util.Scanner;;

class Points{
    int x, y;
    public Points(int a, int b){
        x = a;
        y = b;
    }
}

    class HotSpot {
    Scanner baca = new Scanner(System.in);
    private LinkedHashSet<Points> posisi = new LinkedHashSet<Points>();

    public void readPoints() {
        int x = baca.nextInt();
        int y = baca.nextInt();
        int cek = 0;
        for (Points point : posisi) {
            if (point.x==x && point.y==y){
                cek=1;
            }
        }
        if (cek==0){
            posisi.add(new Points(x, y));
        }
    }

    public void printPoints() {
        System.out.println(posisi.size());
        for (Points point : posisi) {
            if (point.y > 0) {
                System.out.print("(" + point.x + "," + point.y + ")");
            }
        }
        System.out.println();
    }}

    public class HotSpotmain{
    public static void main(String[] args) {
        HotSpot koor = new HotSpot();
        //int a,b;
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        for (int i = 0; i < n; i++) {
            koor.readPoints();
        }
        koor.printPoints();
        read.close();
    }
}
