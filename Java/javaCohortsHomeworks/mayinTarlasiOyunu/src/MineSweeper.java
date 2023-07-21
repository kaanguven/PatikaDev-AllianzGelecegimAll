import java.util.Scanner;

public class MineSweeper {
    private int rowSize; // Satır sayısı
    private int colSize; // Sütun sayısı
    private int[][] mineField; // Mayın tarlası
    private boolean[][] revealed; // Açılan noktaların durumu
    private int remainingCells; // Kullanıcının seçmesi gereken kalan nokta sayısı
    private int mineCount; // Mayın sayısı

    public MineSweeper(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        mineField = new int[rowSize][colSize];
        revealed = new boolean[rowSize][colSize];
        remainingCells = rowSize * colSize;
        mineCount = remainingCells / 4;

        // Mayın tarlasını başlangıçta -1 ile doldur
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                mineField[i][j] = -1;
            }
        }

        // Mayınları yerleştir
        placeMines();
    }

    // Mayınları rastgele yerleştir
    private void placeMines() {
        int minesPlaced = 0;
        while (minesPlaced < mineCount) {
            int randRow = (int) (Math.random() * rowSize);
            int randCol = (int) (Math.random() * colSize);

            // Eğer belirtilen konumda daha önce mayın yoksa, mayını yerleştir
            if (mineField[randRow][randCol] != 9) {
                mineField[randRow][randCol] = 9; // 9, mayın sembolü
                minesPlaced++;
            }
        }
    }

    // Oyunu başlat ve kullanıcıdan nokta seçimleri al
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (remainingCells > mineCount) {
            printMineField();
            System.out.print("Satır seçin (0 - " + (rowSize - 1) + "): ");
            int selectedRow = scanner.nextInt();
            System.out.print("Sütun seçin (0 - " + (colSize - 1) + "): ");
            int selectedCol = scanner.nextInt();

            // Geçerli bir nokta mı kontrol et
            if (selectedRow < 0 || selectedRow >= rowSize || selectedCol < 0 || selectedCol >= colSize) {
                System.out.println("Geçersiz nokta. Lütfen tekrar deneyin.");
                continue;
            }

            // Noktaya daha önce tıklanmış mı kontrol et
            if (revealed[selectedRow][selectedCol]) {
                System.out.println("Bu noktaya daha önce tıkladınız. Lütfen tekrar deneyin.");
                continue;
            }

            // Noktayı aç
            revealCell(selectedRow, selectedCol);

            // Oyunu kontrol et
            if (mineField[selectedRow][selectedCol] == 9) {
                System.out.println("Mayına bastınız! Oyunu kaybettiniz.");
                break;
            }

            // Oyunu kazandın mı kontrol et
            if (remainingCells == mineCount) {
                System.out.println("Tebrikler! Tüm noktaları seçtiniz. Oyunu kazandınız.");
                break;
            }
        }

        scanner.close();
    }

    // Seçilen noktanın etrafındaki mayınları kontrol et ve sayısını ilgili noktaya yaz
    private void revealCell(int row, int col) {
        revealed[row][col] = true;
        remainingCells--;

        int[][] adjacentOffsets = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        int adjacentMineCount = 0;
        for (int[] offset : adjacentOffsets) {
            int adjacentRow = row + offset[0];
            int adjacentCol = col + offset[1];

            if (adjacentRow >= 0 && adjacentRow < rowSize && adjacentCol >= 0 && adjacentCol < colSize) {
                if (mineField[adjacentRow][adjacentCol] == 9) {
                    adjacentMineCount++;
                }
            }
        }

        mineField[row][col] = adjacentMineCount;
    }

    // Mayın tarlasını ekrana bas
    private void printMineField() {
        System.out.println("Mayın Tarlası:");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (revealed[i][j]) {
                    System.out.print(mineField[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}