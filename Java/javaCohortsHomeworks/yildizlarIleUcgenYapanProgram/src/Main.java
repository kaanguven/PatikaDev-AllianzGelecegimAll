import java.util.Scanner;

/*
Java'da döngüler kullanılarak yıldızlar ile üçgen yapıyoruz.


 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Üçgenin satır sayısını girin: ");
        int satirSayisi = scanner.nextInt();

        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}