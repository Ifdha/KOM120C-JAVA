import java.util.Scanner;

interface AritmatikaDasar {
    double tambah(double a, double b);
    double kurang(double a, double b);
    double kali(double a, double b);
    double bagi(double a, double b);
}

interface AritmatikaLanjut {
    double akarKuadrat(double a);
    double pangkat(double a, double b);
}

interface KalkulatorSaintifik extends AritmatikaDasar, AritmatikaLanjut {
    void clear();
}

class Kalkulator implements KalkulatorSaintifik {
    private double currentValue;

    public Kalkulator() {
        this.currentValue = 0;
    }

    public double tambah(double a, double b) {
        return a + b;
    }

    public double kurang(double a, double b) {
        return a - b;
    }

    public double kali(double a, double b) {
        return a * b;
    }

    public double bagi(double a, double b) {
        return a / b;
    }

    public double akarKuadrat(double a) {
        return Math.sqrt(a);
    }

    public double pangkat(double a, double b) {
        return Math.pow(a, b);
    }

    public void clear() {
        this.currentValue = 0;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}

public class KalkulatorMG11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalkulator bilangan = new Kalkulator();

        String input = scanner.next();
        char operator = input.charAt(0);

        while (operator != '~') {
            switch (operator) {
                case '+':
                    double nilaiTambah = scanner.nextDouble();
                    double hasilTambah = bilangan.tambah(bilangan.getCurrentValue(), nilaiTambah);
                    bilangan.setCurrentValue(hasilTambah);
                    System.out.printf("%.2f\n", hasilTambah);
                    break;
                case '-':
                    double nilaiKurang = scanner.nextDouble();
                    double hasilKurang = bilangan.kurang(bilangan.getCurrentValue(), nilaiKurang);
                    bilangan.setCurrentValue(hasilKurang);
                    System.out.printf("%.2f\n", hasilKurang);
                    break;
                case '*':
                    double nilaiKali = scanner.nextDouble();
                    double hasilKali = bilangan.kali(bilangan.getCurrentValue(), nilaiKali);
                    bilangan.setCurrentValue(hasilKali);
                    System.out.printf("%.2f\n", hasilKali);
                    break;
                case '/':
                    double nilaiBagi = scanner.nextDouble();
                    double hasilBagi = bilangan.bagi(bilangan.getCurrentValue(), nilaiBagi);
                    bilangan.setCurrentValue(hasilBagi);
                    System.out.printf("%.2f\n", hasilBagi);
                    break;
                case '^':
                    double nilaiPangkat = scanner.nextDouble();
                    double hasilPangkat = bilangan.pangkat(bilangan.getCurrentValue(), nilaiPangkat);
                    bilangan.setCurrentValue(hasilPangkat);
                    System.out.printf("%.2f\n", hasilPangkat);
                    break;
                case '#':
                    double hasilAkarKuadrat = bilangan.akarKuadrat(bilangan.getCurrentValue());
                    bilangan.setCurrentValue(hasilAkarKuadrat);
                    System.out.printf("%.2f\n", hasilAkarKuadrat);
                    break;
                case 'C':
                    bilangan.clear();
                    System.out.println("0.00");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }

            input = scanner.next();
            operator = input.charAt(0);
        }

        scanner.close();
    }
}
