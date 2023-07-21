import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Kelimeyi giriniz: ");
        String kelime = input.nextLine();
        System.out.println((isPalindromik(kelime)));

    }

    public static boolean isPalindromik(String kelime) {
        int uzunluk = kelime.length();
        for (int i = 0; i < uzunluk / 2; i++) {
            if (kelime.charAt(i) != kelime.charAt(uzunluk - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}