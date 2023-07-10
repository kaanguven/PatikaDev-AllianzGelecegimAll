import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int birthDate,zodiac;
        String horoscope;

        Scanner input = new Scanner(System.in);

        System.out.println("Doğum tarihinizi giriniz: ");

        birthDate = input.nextInt();

        zodiac = birthDate % 12;

        System.out.println("Burç hesabı için kalan: "+zodiac);

        switch (zodiac){

            case 0:
                horoscope="Maymun";
                break;
            case 1:
                horoscope="Horoz";
                break;

            case 2:
                horoscope="Köpek";
                break;
            case 3:
                horoscope="Domuz";
                break;
            case 4:
                horoscope="Fare";
                break;
            case 5:
                horoscope="Öküz";
                break;
            case 6:
                horoscope="Kaplan";
                break;
            case 7:
                horoscope="Tavşan";
                break;
            case 8:
                horoscope="Ejderha";
                break;
            case 9:
                horoscope="Yılan";
                break;
            case 10:
                horoscope="At";
                break;
            case 11:
                horoscope="Koyun";
                break;

            default:
                horoscope=null  ;

        }

        System.out.println("Burç: "+horoscope);


        }
    }
