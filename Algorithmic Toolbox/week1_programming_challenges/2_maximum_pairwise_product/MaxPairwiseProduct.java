import java.util.*;
import java.io.*;

import static java.lang.Long.max;


public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = max(max_product, numbers[first] * numbers[second]);
            }
        }
        return max_product;
    }

    static long getMaxPairwiseProductFast(long[] numbers) {
        int n = numbers.length;
        int max_index_1 = 0;
        int max_index_2 = 1;

        if (numbers[1] > numbers[0]) {
            max_index_1 = 1;
            max_index_2 = 0;
        }

        for (int i = 2; i < n; ++i) {
            if (numbers[i] > numbers[max_index_1]) {
                max_index_2 = max_index_1; // current max becomes new min
                max_index_1 = i; // we found new max
            } else {
                if (numbers[i] > numbers[max_index_2]) {
                    max_index_2 = i;
                }
            }
        }
        return numbers[max_index_1] * numbers[max_index_2];
    }

    public static void main(String[] args) {
/*        while (true) {
            Random random = new Random();
            int n = Math.abs(random.nextInt()) % 10 + 2;
            long[] numbers = new long[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Math.abs(random.nextInt()) % 1000;
            }

            System.out.println("Numbers: " + Arrays.toString(numbers));

            long max_product = getMaxPairwiseProduct(numbers);
            long max_product_fast = getMaxPairwiseProductFast(numbers);

            if (max_product != max_product_fast) {
                System.out.println("Test Failed");
                System.out.println(Arrays.toString(numbers));
                System.out.println(max_product);
                System.out.println(max_product_fast);
                break;
            } else {
                System.out.println("Test Passed");
                System.out.println(Arrays.toString(numbers));
            }

        }*/

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}