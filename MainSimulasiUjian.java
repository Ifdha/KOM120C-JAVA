import java.util.*;
import java.util.Scanner;

interface Answerable {
    public boolean cekJawaban(String jawaban);
}

class Soal implements Answerable {
    private String question;
    private String answerkey;

    public Soal(String question, String answerkey) {
        this.question = question;
        this.answerkey = answerkey;
    }

    public boolean cekJawaban(String jawaban) {
        return answerkey.equalsIgnoreCase(jawaban);
    }

    public String getquestion() {
        return question;
    }
}

class SoalIsian extends Soal {
    public SoalIsian(String question, String answerkey) {
        super(question, answerkey);
    }
}

class Ujian {
    private List<Soal> listQuestion = new ArrayList<>();

    public void addSoal(Soal pertanyaan) {
     listQuestion.add(pertanyaan);
    }

    public double nilaiUjian(List<Integer> nomorJawaban, List<String> jawaban) {
        int RightAnswer = 0;

        for (int i = 0; i < nomorJawaban.size(); i++) {
            int nomor = nomorJawaban.get(i) - 1;
            String jawabannya = jawaban.get(i);
            Soal soal = listQuestion.get(nomor);

            if (soal.cekJawaban(jawabannya)) {
                RightAnswer++;
            }
        }
        return (double) RightAnswer / listQuestion.size() * 100;
    }
}

public class MainSimulasiUjian {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int jumlahquestion = read.nextInt();
        read.nextLine();

        Ujian test = new Ujian();

        for (int i = 0; i < jumlahquestion; i++) {
            String question = read.nextLine();
            String answerkey = read.nextLine();
            Soal soal = new SoalIsian(question, answerkey);
            test.addSoal(soal);
        }

        int jawabanyangdiberikan = read.nextInt();
        read.nextLine();

        List<Integer> nomorJawaban = new ArrayList<>();
        List<String> jawaban = new ArrayList<>();

        for (int i = 0; i < jawabanyangdiberikan; i++) {
            int nomor = read.nextInt();
            read.nextLine();
            String jawabannya = read.nextLine();
            nomorJawaban.add(nomor);
            jawaban.add(jawabannya);
        }

        double nilai = test.nilaiUjian(nomorJawaban, jawaban);
        System.out.printf("%.2f%n", nilai);
    }
}