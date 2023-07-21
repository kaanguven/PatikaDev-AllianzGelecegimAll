import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mayın tarlasının satır sayısını girin: ");
        int rowSize = scanner.nextInt();
        System.out.print("Mayın tarlasının sütun sayısını girin: ");
        int colSize = scanner.nextInt();

        MineSweeper game = new MineSweeper(rowSize, colSize);
        game.playGame();

        scanner.close();
    }
    }
