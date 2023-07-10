import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int yil, mod;


        Scanner inp = new Scanner(System.in);
        System.out.println("Doğum yılınızı giriniz :");
        yil = inp.nextInt();

        mod = yil % 4;

        if ((yil % 4 == 0 || yil % 400 == 0)) {
            System.out.println("Artık yıl = " + yil);
        } else {
            System.out.println("Artık yıl değil = " + yil);
        }
    }
}