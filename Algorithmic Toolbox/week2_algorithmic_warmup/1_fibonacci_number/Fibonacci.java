import java.util.Random;
import java.util.Scanner;

public class Fibonacci {
    private static long[] fib;

    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long calc_fib_sec(int n) {

        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                fib[i] = i;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        fib = new long[n + 1];
        //System.out.println(calc_fib(n));
        System.out.println(calc_fib_sec(n));

/*
            //Stress Test
            while (true) {
            Random random = new Random();
            int fib_n = random.nextInt(45);
            fib = new long[fib_n + 1];
            if (calc_fib(fib_n) != calc_fib_sec(fib_n)) {
                System.out.println("Failed Test Case : n = " + fib_n);
                break;
            } else {
                System.out.println("OK  n: " + fib_n);
            }
        }*/
    }
}
