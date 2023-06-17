import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

class Bilangan {
    ArrayList<Integer> data = new ArrayList<Integer>();
    private int ukuran;
    private int ukuranafter;
    private double sum;
    private double sumafter;

    Bilangan(){
        ukuran = 0;
        ukuranafter = ukuran;
        sum = 0;
        sumafter = 0;
    }

    public void add(int angka){
        data.add(angka);
        ukuran++;
        sum += angka;
        ukuranafter = ukuran;
    }

    public int getjumlah(){
        return ukuran;
    }

    public double rataan(){
        double mean;
        if(sum == 0){mean = -9.99;}
        else{
        mean = (double) sum/ukuran;}
        return mean;
    }

    public void remove(int posisi, int dihapus){
        data.remove(posisi-1-dihapus);
        ukuranafter--;
    }

    public int getukuranafter(){
        return ukuranafter;
    }

    public double getsumafter(){
        for(int i=0; i<data.size(); i++){
            sumafter = sumafter + data.get(i);
        }
        return sumafter;
    }

    public void setSumafter(double sumafter) {
        this.sumafter = sumafter;
    }

    public double rataanafter(double sumafter){
        double meanafter;
        if(this.sumafter == 0){meanafter = -9.99;}
        else{
            meanafter = (double) sumafter/ukuranafter;
        }
        return meanafter;
    }
}

public class Arrayjava {
    public static void main(String[] args){
        Bilangan objek = new Bilangan();
        Scanner read = new Scanner(System.in);
        int input,count = 0;
        input = read.nextInt();
        while(input != -9){
            objek.add(input);
            input = read.nextInt();
        }
        int hapus;
        hapus = read.nextInt();
        while(hapus != -9){
            objek.remove(hapus,count);
            count++;
            hapus = read.nextInt();
        }
        double jumlahcurrent = objek.getsumafter();

        System.out.printf("%d %d\n%.2f %.2f\n", objek.getjumlah(),objek.getukuranafter(),
        objek.rataan(), objek.rataanafter(jumlahcurrent));
    }
    
}