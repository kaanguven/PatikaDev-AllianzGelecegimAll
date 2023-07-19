
public class Main {
    public static void main(String[] args) {

        int[] testList = {10,10,3,4,5,64,6,4,3,7,7,7,7};


        int frequency;
        int number;

        for (int i = 0; i < testList.length; i++) {
            frequency = 1;
            number = testList[i];

            for (int j = i + 1; j < testList.length; j++) {
                if (testList[i] == testList[j]) {
                    frequency++;
                }
            }

            if (frequency > 1) {
                System.out.println(number + " Frekansı: " + frequency);
            }
        }
    }
}