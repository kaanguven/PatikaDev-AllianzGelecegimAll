import java.util.*;
public class Main {
    public static void main(String[] args) {
        double pearPrice = 2.14, applePrice=3.67, tomatoPrice=1.11, bananaPrice=0.95, eggplantPrice=5;
        double totalPrice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Armut KG:");
        double pearKg =scanner.nextDouble();

        System.out.println("Elma KG:");
        double appleKg =scanner.nextDouble();

        System.out.println("Domates KG:");
        double tomatoKg =scanner.nextDouble();

        System.out.println("Muz KGz:");
        double bananaKg =scanner.nextDouble();

        System.out.println("Patlıcan KG:");
        double eggplantKg =scanner.nextDouble();
        totalPrice = (pearKg * pearPrice + appleKg * applePrice + tomatoKg * tomatoPrice + bananaKg * bananaPrice + eggplantKg * eggplantPrice);

        System.out.println("Total price: "+ totalPrice);

    }
}