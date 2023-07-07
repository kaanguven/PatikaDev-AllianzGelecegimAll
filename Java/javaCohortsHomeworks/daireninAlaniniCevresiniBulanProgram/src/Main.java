import java.util.*;
public class Main {
    public static void main(String[] args) {
        int r, a;           // "r" : dairenin yarıçapı. "a" : daire diliminin açısı
        double pi = 3.14;

        Scanner input = new Scanner(System.in);
        System.out.println("Dairenin yarıçapını giriniz : ");
        r = input.nextInt();
        System.out.println("Daire diliminin açısını giriniz : ");
        a = input.nextInt();

        double area = pi * r * r;
        double perimeter = 2 * pi * r;
        double sliceArea = (pi * r * r * a) / 360;

        System.out.println("Dairenin alanı : " + area);
        System.out.println("Dairenin çevresi : " + perimeter);
        System.out.println("Daire diliminin alanı : " + sliceArea);
    }
}