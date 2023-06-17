import java.util.*;
import java.util.Scanner;


class Person{
    private String nama;
    private int usia;
    private int tinggi;
    private double berat;

    Person(){
        nama = "";
        usia = tinggi = 0;
        berat = 0;
    }

    public void setperson(String nama, int usia, int tinggi, double berat){
        this.nama = nama;
        this.usia = usia;
        this.tinggi = tinggi;
        this.berat = berat;
    }
    
    public String getnama(){
        return nama;
    }
    public int getusia(){
        return usia;
    }
    public int gettingi(){
        return tinggi;
    }
    public double getberat(){
        return berat;
    }

    public void print(){
        System.out.printf("%s %d\n", nama, usia);}
}

public class Personjava {
    public static void main(String[] args){
        int n;
        int sum = 0;
        Scanner baca = new Scanner(System.in);
        n = baca.nextInt();
        Person orag[] = new Person[n];
        for(int i=0; i<n; i++){
            orag[i] = new Person();
            String nama = baca.next();
            int usia = baca.nextInt();
            int tinggi = baca.nextInt();
            double berat = baca.nextDouble();
            orag[i].setperson(nama, usia, tinggi, berat);
            sum = sum + orag[i].gettingi();}
        double meantinggi = (double) sum/n;
        int count = 0;
        for(int i=0; i<n; i++){
            if(orag[i].gettingi() >  meantinggi){
                count++;
            }
        }
        for(int i=0; i<n; i++){
            orag[i].print();
        }
        System.out.printf("%.2f\n", meantinggi);
        System.out.println(count);
    }
}
