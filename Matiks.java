import java.util.*;
import java.util.Scanner;

public class Matiks{
    public static void main(String[] args) {
        int a[][] = new int[100][100];
        Scanner input = new Scanner(System.in);
        int baris, kolom;
        baris = input.nextInt();
        kolom = input.nextInt();
        for(int i = 0; i < baris; i++){
            for (int j = 0; j < kolom; j++){
                a[i][j] = input.nextInt();
            }
        }
        for(int i = 0; i < baris; i++){
            for (int j = 0; j < kolom; j++){
                System.out.print(a[i][j]);
                if (j==kolom-1) {
                    System.out.println();
                }
                else System.out.print(" ");
            }
        }
    }
}