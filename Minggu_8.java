import java.util.Scanner;

class pecahan{
    public int a;
    public int b;
    public int c;

    pecahan(){
        a = c = 0;
        b = 1;
    }

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
        a = a+b/c;
        b = b%c;    //pembilang = pembilang % penyebut
        t = fpb(b,c); 
        b = b/t; //pembilang = pembilang/t
        c = c/t; //penyebut = penyebut/t
    }

    public void set(int aa, int bb, int cc){
        a = aa;
        b = bb;
        c = cc;
        simple();
    }
    public void add(int aa, int bb, int cc){
        a = a + aa;
        b = b * cc + bb * c;
        c = c * cc;
        simple();
    }
    public void mul(int aa, int bb, int cc){
        b = a * c + b;
        bb = aa * cc + bb;
        a = aa = 0;
        b = b *bb;
        c = c * cc;
        simple();
    }

    public void inc(){
        a++;
    }

    public void dec(){
        a--;
    }
    public void keluarkan(){
        if(b == 0){System.out.println(a);}
        else
        System.out.printf("%d %d/%d\n",a,b,c);
    }
}

public class Minggu_8 {
    public static void main(String[] args){
        pecahan objek = new pecahan();
        String input;
        int a,b,c;
        Scanner baca = new Scanner(System.in);
        input = baca.next();
        while( !input.equals("end")){
            if(input.equals("set")){
                a = baca.nextInt();
                b = baca.nextInt();
                c = baca.nextInt();
                objek.set(a,b,c);
            }
            else if(input.equals("add")){
                a = baca.nextInt();
                b = baca.nextInt();
                c = baca.nextInt();
                objek.add(a, b, c);
            }
            else if (input.equals("mul")){
                a = baca.nextInt();
                b = baca.nextInt();
                c = baca.nextInt();
                objek.mul(a, b, c);
            }
            else if (input.equals("p")){
                objek.keluarkan();
            }
            else if (input.equals("inc")){
                objek.inc();
            }
            else{
                objek.dec();
            }
            input = baca.next();
        }
    }
}
