import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        int chunkSize = numbers.size() / 4;
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;

            ArrayList<Integer> subList = new ArrayList<>(numbers.subList(startIndex, endIndex));

            Thread thread = new Thread(new NumberProcessor(subList, evenNumbers, oddNumbers));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }
}

class NumberProcessor implements Runnable {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> evenNumbers;
    private ArrayList<Integer> oddNumbers;

    public NumberProcessor(ArrayList<Integer> numbers, ArrayList<Integer> evenNumbers, ArrayList<Integer> oddNumbers) {
        this.numbers = numbers;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(number);
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(number);
                }
            }
        }
    }
}
