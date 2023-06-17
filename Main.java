abstract class BangunDatar{
    protected double luas = 0.0;
    protected double keliling = 0.0;
    
    abstract double hitungLuas();
    abstract double hitungKeliling();
    
    public void print(){
        System.out.println("Luas    : " + luas);
        System.out.println("Keliling: " + keliling);
    }
}

class Lingkaran extends BangunDatar{
    protected double radius;
    
    public Lingkaran(double radius){
        setRadius(radius);
    }
    
    public void setRadius(double radius){
        this.radius = radius;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    public double hitungLuas(){
        return 3.14*radius*radius;    
    }
    
    public double hitungKeliling(){
        return 2*3.14*radius;
    }
}

class Segiempat extends BangunDatar{
    protected double panjang = 0.0;
    protected double lebar = 0.0;

    public Segiempat(double panjang, double lebar){
        setPanjang(panjang);
        setLebar(lebar);
    }
    
    public void setPanjang(double panjang){
        this.panjang = panjang;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    public void setLebar(double lebar){
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double hitungLuas(){
        return panjang * lebar;    
    }
    
    public double hitungKeliling(){
        return 2 * (panjang + lebar);
    }
    
}

class Silinder{
    protected double radius;
    protected double tinggi;
    protected double volume;
    protected double luas;
    protected Lingkaran alas;
    protected Segiempat selimut;
    
    public Silinder(double radius, double tinggi){
        this.radius = radius;
        this.tinggi = tinggi;
        alas = new Lingkaran(radius);
        selimut = new Segiempat(alas.hitungKeliling(), tinggi);
        volume = hitungVolume();
        luas = hitungLuas();
    }
    
    public double hitungLuas(){
        return 2 * alas.hitungLuas() + selimut.hitungLuas();
    }
    
    public double hitungVolume(){
        return alas.hitungLuas()*this.tinggi;
    }
    
    public void print(){
        System.out.println("Luas    : " + luas);
        System.out.println("Volume  : " + volume);
    }
}

public class Main
{
	public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran(10);
        lingkaran.print();
        
        Segiempat segiempat = new Segiempat(20, 10);
        segiempat.print();
        
        Silinder silinder = new Silinder(10, 10);
        silinder.print();
	}
}
