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

abstract class Penjumlahan{
    abstract void finalsum();
}

class OpDesimal extends Penjumlahan{
    public Desimal a;
    public Desimal b;

    OpDesimal(Desimal a, Desimal b){
        this.a = a;
        this.b = b;
    }
    
    void finalsum(){
        a.jumlah(b);
        a.print();
    }
}

class OpPecahan extends Penjumlahan{
    public Pecahan a;
    public Pecahan b;
    
    OpPecahan(Pecahan a, Pecahan b){
        this.a = a;
        this.b = b;
    }
    
    void finalsum(){
        a.jumlah(b);
        a.print();
    }
    
}
public class PolymorAbs {
    public static void main(String[] args){
        Scanner baca = new Scanner(System.in);
        int n = baca.nextInt();

        ArrayList<Penjumlahan> arr = new ArrayList<Penjumlahan>();
        
        for(int i=0; i<n; i++){
            int type = baca.nextInt();
            if(type == 1){
                Desimal a = new Desimal(baca.nextDouble());
                Desimal b = new Desimal(baca.nextDouble());
                OpDesimal o = new OpDesimal(a, b);
                arr.add(o); //fungsi add merupakan fungsi dari arraylist yg berguna untuk memasukkan inputan ke array
               
            }
            else{
                Pecahan a = new Pecahan(baca.nextInt(), baca.nextInt());
                Pecahan b = new Pecahan(baca.nextInt(), baca.nextInt());
                OpPecahan o = new OpPecahan(a, b);
                arr.add(o);
            }
        }
        int i = baca.nextInt();
        int j = baca.nextInt();

        for(int x=i-1; x<=j-1; x++)
            arr.get(x).finalsum();
    }
}
