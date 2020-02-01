import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd_Euclidean(int a, int b) {

        if (a < b) {
            int tem = a;
            a = b;
            b = tem;
        }

        int gcd = 0;

        while (a != 0 || b != 0) {
            int r = a % b;
            if (r == 0) {
                gcd = b;
                break;
            }
            a = b;
            b = r;
        }
        return gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        //System.out.println(gcd_naive(a, b));
        System.out.println(gcd_Euclidean(a, b));

/*        //Stress Test
        while (true) {
            Random random = new Random();
            int a = random.nextInt(1000) + 1;
            int b = random.nextInt(1000) + 1;
            if (gcd_Euclidean(a, b) != gcd_naive(a, b)) {
                System.out.println("Failed Test Case : a = " + a + " ,  b=" + b);
                break;
            } else {
                System.out.println("OK  a= " + a + " ,  b=" + b);
            }
        }*/
    }
}
