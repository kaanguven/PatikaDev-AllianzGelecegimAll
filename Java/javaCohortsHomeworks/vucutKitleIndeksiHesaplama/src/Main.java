import java.util.*;
public class Main {
    public static void main(String[] args) {

        int weight;
        double height;

        Scanner input = new Scanner(System.in);

        System.out.println("Boyunuzu (m) giriniz : ");
        height = input.nextDouble();
        System.out.println("Kilonuzu giriniz : ");
        weight = input.nextInt();

        double indeks = weight / (height * height);
        System.out.println("Vücut Kitle İndeksi : " + indeks);
    }
}