import java.util.*;
public class Main {
    public static void main(String[] args) {
        int a, b;
        double c;

        Scanner input = new Scanner(System.in);
        System.out.println("Dik üçgen 1. Kenarı Giriniz : ");
        a = input.nextInt();
        System.out.println("Dik üçgen 2. Kenarı Giriniz : ");
        b = input.nextInt();

        c = Math.sqrt((a*a) + (b*b));
        System.out.println("Hipotenüs : " + c);

        System.out.println("-----------------------");


        int d, e, f;
        double u, alan;

        System.out.println("Üçgen 1. Kenarı Giriniz : ");
        d = input.nextInt();
        System.out.println("Üçgen 2. Kenarı Giriniz : ");
        e = input.nextInt();
        System.out.println("Üçgen 3. Kenarı Giriniz : ");
        f = input.nextInt();

        u = (a+b+c)/2;
        alan = Math.sqrt( u * (u-d) * (u-e) * (u-f) );
        System.out.println("Üçgenin alanı : " + alan);

    }
}
