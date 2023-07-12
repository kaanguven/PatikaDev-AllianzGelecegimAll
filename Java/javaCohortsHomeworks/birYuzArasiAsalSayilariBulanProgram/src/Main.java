/*

Java ile 1 - 100 arasındaki asal sayıları ekrana yazdıran programı yazınız.

 */
public class Main {
    public static void main(String[] args) {
        for (int i=2;i<100;i++){
            System.out.print(isPrime(i) ? i+" " : "");
        }

    }
    public static boolean isPrime(int num){
        for(int i=2;i<(num/2)+1;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}