import java.util.Scanner;

public class Main {

    /*
    Java ile kullanıcının girdiği değerler ile üslü sayı hesaplayan programı "For Döngüsü" kullanarak yapınız.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tabanı girin: ");
        int taban = scanner.nextInt();
        System.out.print("Üssü girin: ");
        int us = scanner.nextInt();

        int sonuc = 1;
        for (int i = 0; i < us; i++) {
            sonuc *= taban;
        }

        System.out.println(taban + "^" + us + " = " + sonuc);
    }
}
