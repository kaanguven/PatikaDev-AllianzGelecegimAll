
public class Main {
    public static void main(String[] args) {
        int size = 7; // B harfinin boyutu
        char[][] letterB = new char[size][size];

        // B harfini oluşturma
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0 || j == size - 1 || i == size / 2 || (i == 0 && j != size - 1) || (i == size - 1 && j != size - 1)) {
                    letterB[i][j] = '*';
                } else {
                    letterB[i][j] = ' ';
                }
            }
        }

        // B harfini ekrana yazdırma
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(letterB[i][j] + " ");
            }
            System.out.println();
        }
    }
}