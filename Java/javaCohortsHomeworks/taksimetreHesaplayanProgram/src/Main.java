import java.util.*;
public class Main {
    public static void main(String[] args) {
        int distance;
        double total;

        Scanner input = new Scanner(System.in);
        System.out.println("Gidilen mesafeyi giriniz (km) : ");
        distance = input.nextInt();

        total = 10 + (distance * 2.20);
        total = (total < 20) ? 20 : total;
        System.out.println("Tutar = " + total);
    }
}