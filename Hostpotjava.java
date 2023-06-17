import java.util.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Titik{
    private int x,y;

    public void setTitik(int x, int y){
       this.x = x;
       this.y = y;
    }

    // public void add(int a, int b){
    //     Set <Titik> sr = new HashSet<Titik>();
    //     sr.add(a,b);
    // }

    // public void print(){
    //     if (sr>0)
    //     System.out.println(sr);
    // }
}

public class Hostpotjava {
    public static void main(String[] args){

        Scanner baca = new Scanner(System.in);

        LinkedHashSet<Integer> sr = new LinkedHashSet<Integer>();

        sr.add(5);
        sr.add(10);
        sr.add(0);
        sr.add(9);
        sr.add(1);
        sr.add(10);
        sr.add(10);
        sr.add(5);

        System.out.println(sr);

    }
}
