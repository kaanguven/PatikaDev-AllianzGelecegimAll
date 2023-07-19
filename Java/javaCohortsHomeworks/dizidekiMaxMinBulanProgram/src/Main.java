
public class Main {
    public static void main(String[] args) {

        int[] testList = {1,2,3,4,5,11,24,25,-3,52,-99};

        findMaxMinValues(testList);
        System.out.println(testList[0]);




    }

    public static void findMaxMinValues(int[] numbers) {
        if (numbers.length == 0) {
            System.out.println("Dizi boş.");
            return;
        }

        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }

            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        System.out.println("Maksimum Değer: " + max);
        System.out.println("Minimum Değer: " + min);
    }

}