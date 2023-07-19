import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] testList = {1,2,3,4,5,3,7,2,9,44,23,24,55,58,55,723,9 ,24};

        for (int i = 0; i < testList.length; i++) {
            if(testList[i]%2==0){
                for (int j = i+1; j < testList.length; j++) {
                    if (testList[j]==testList[i]){
                        System.out.println("Tekrar eden sayı: "+ testList[i]);
                }

                }

            }


        }



    }

}