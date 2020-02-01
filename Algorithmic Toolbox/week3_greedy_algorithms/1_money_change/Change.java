import java.util.Arrays;
import java.util.Scanner;

public class Change {
    static int[] coinDenominations = new int[]{10,5,1};

    private static int getChange(int m) {
        int numberOfCoins = 0;
        //write your code here
        for (int i = 0; i < coinDenominations.length; i++) {
             numberOfCoins +=  m / coinDenominations[i];
            m = m % coinDenominations[i];
            if(m == 0) break;
        }

        return numberOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

