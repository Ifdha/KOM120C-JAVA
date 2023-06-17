import java.util.Scanner;
import java.util.ArrayList;

abstract class BilangaN{
    abstract public void print();}


class Desimal extends BilangaN{
    public double nilai;
    
    Desimal(double input){
        nilai = input;}
    
    public void jumlah(Desimal b){
        this.nilai = this.nilai + b.nilai;}
    
    public void print(){
        System.out.printf("%.2f\n", nilai);}
}

class Pecahan extends BilangaN{
    public int pembilang;
    public int penyebut;
    
    Pecahan(int pembilang, int penyebut){
        this.pembilang = pembilang;
        this.penyebut = penyebut;}
    
    public int fpb(int bb, int cc){
        while(cc != 0){
            int t = bb%cc;
            bb = cc;
            cc = t;
        }
        return bb;
    }

    public void simple(){
        int t;
        t = fpb(pembilang,penyebut);
        pembilang = pembilang/t;
        penyebut = penyebut/t;
    }
    void jumlah(Pecahan b){
        int p = this.pembilang;
        int q = this.penyebut;
        int r = b.pembilang;
        int s = b.penyebut;
        
        this.pembilang = p*s + q*r;
        this.penyebut = q * s;
        
        simple();
    }
    
    public void print(){
        System.out.println(pembilang + " " + penyebut);
    }
}

interface Penjumlahan{
    public void finalsum();
}

class OpDesimal implements Penjumlahan{
    public Desimal a;
    public Desimal b;

    OpDesimal(Desimal a, Desimal b){
        this.a = a;
        this.b = b;
    }
    
    public void finalsum(){
        a.jumlah(b);
        a.print();
    }
}

class OpPecahan implements Penjumlahan{
    public Pecahan a;
    public Pecahan b;
    
    OpPecahan(Pecahan a, Pecahan b){
        this.a = a;
        this.b = b;
    }
    
    public void finalsum(){
        a.jumlah(b);
        a.print();
    }
    
}

public class PolymorInterfc {
    public static void main(String[] args){
        Scanner baca = new Scanner(System.in);
        int n = baca.nextInt();

        ArrayList<Penjumlahan> arr = new ArrayList<Penjumlahan>();
        
        for(int i=0; i<n; i++){
            int type = baca.nextInt();
            if(type == 1){
                Desimal a = new Desimal(baca.nextDouble());
                Desimal b = new Desimal(baca.nextDouble());
                OpDesimal c = new OpDesimal(a, b);
                arr.add(c); //fungsi add merupakan fungsi dari arraylist yg berguna untuk memasukkan inputan ke array

            }
            else{
                Pecahan a = new Pecahan(baca.nextInt(), baca.nextInt());
                Pecahan b = new Pecahan(baca.nextInt(), baca.nextInt());
                OpPecahan c = new OpPecahan(a, b);
                arr.add(c);
            }
        }
        int i = baca.nextInt();
        int j = baca.nextInt();

        for(int x=i-1; x<=j-1; x++)
            arr.get(x).finalsum();
    }
    
}
