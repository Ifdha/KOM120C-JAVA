import java.util.*;

public class Data {
    ArrayList<Integer> angka1 = new ArrayList<Integer>();
    ArrayList<Integer> angka2 = new ArrayList<Integer>();
    double sumBefore = 0;
    double sumAfter = 0;
    int nBefore = 0;
    int nAfter = 0;
    public Scanner sc = new Scanner(System.in);
    public void readAngka() {
        int num = sc.nextInt();
        while (num != -9) {
            angka1.add(num);
            angka2.add(num);
            sumBefore += num;
            num = sc.nextInt();
        }
        nBefore = angka1.size();
    }

    public void removeAngka() {
        if (nBefore == 0) {
            return;
        }
        boolean[] removed = new boolean[nBefore];
        int pos;
        pos = sc.nextInt();
        while (pos != -9) {
            removed[pos - 1] = true;
            pos = sc.nextInt();
        }
        for (int i = 0; i < nBefore; i++) {
            if (!removed[i]) {
                nAfter++;
                sumAfter += angka1.get(i);
            }
        }
        sc.close();
    }

    public void prin() {
        System.out.printf("%d %d\n", nBefore, nAfter);
        if (nBefore > 0) {
            System.out.printf("%.2f ", sumBefore / nBefore);
        } else {
            System.out.println("-9.99 ");
        }
        if (nAfter > 0) {
            System.out.printf("%.2f \n", sumAfter / nAfter);
        } else {
            System.out.println("-9.99 ");
        }
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.readAngka();
        data.removeAngka();
        data.prin();
    }
}