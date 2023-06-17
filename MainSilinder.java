import java.util.*;
import java.util.Scanner;

interface BangunDatar{
    double luas = 0.00;
    
    public double getluas();
}

class Lingkaran implements BangunDatar{
    protected double diameter;

    Lingkaran(double d){
        diameter = d;
    }
    public double getluas(){
        return Math.PI*(diameter/2)*(diameter/2);
    }
}

class Segiempat implements BangunDatar{
    protected double lebar;
    protected double tinggi;

    Segiempat(double w, double h){
        lebar = w;
        tinggi = h;
    }

    public double getluas(){
        return lebar*tinggi;
    }

}

class Silinder{
    protected double diameter;
    protected double lebar;
    protected double tinggi;
    protected Lingkaran alas;
    protected Segiempat selimut;

    public Silinder(double d, double w, double h){
        this.diameter = d;
        this.lebar = w;
        this.tinggi = h;
        alas = new Lingkaran(d);
        selimut = new Segiempat(w, h);
    }

    public double hitungVolume(){
        return alas.getluas()*this.tinggi;
    }
}

public class MainSilinder{
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int N = read.nextInt();
        Silinder[] object = new Silinder[N];

        double sum = 0;
        for(int i = 0; i<N; i++){
            double d = read.nextDouble();
            double w = read.nextDouble();
            double h = read.nextDouble();
            object[i] = new Silinder(d, w, h);
        sum = sum + object[i].hitungVolume();
        }

        double Meanvolume = sum/N;

        int Overvolume = 0;

        for(Silinder itobjects : object){
            if(itobjects.hitungVolume() > Meanvolume){
                Overvolume++;
            }
        }
        
        System.out.printf("%.2f %d\n", Meanvolume, Overvolume);
    } 
}



