
public class Main {
    public static void main(String[] args) {

        int[] list = {1,2,3,4,5,6,7,8,10};

        System.out.println(calculateHarmonicMean(list));




        }

    public static double calculateHarmonicMean(int[] numbers) {
        int n = numbers.length;
        double harmonicSeriesSum = 0;

        for (int number : numbers) {
            harmonicSeriesSum += 1.0 / number;
        }

        return n / harmonicSeriesSum;
    }
    }
