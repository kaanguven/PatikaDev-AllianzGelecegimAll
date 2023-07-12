import java.util.Scanner;

/*

Java döngüler ile fibonacci serisi bulan program yazıyoruz.

 */
public class Main {

        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.print("Eleman sayısını giriniz: ");
            int inp=scan.nextInt();
            if(inp<0){
                System.out.print("Geçersiz değer girdiniz.");
                System.exit(0);
            }
            if(inp==0){
                System.exit(0);
            }
            int sum=0;
            int num=1;
            int tmp=0;
            for(int i=0;i<inp;i++){
                tmp=sum;
                sum+=num;
                num=tmp;
                System.out.println(num+" + "+sum+" = "+(sum+num));
            }

        }
    }
