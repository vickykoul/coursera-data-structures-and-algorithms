import java.util.*;

public class LCM {
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
  private static long lcm_fast(int a, int b) {
    if(a==0 || b == 0 ) return 0;
    long _a =a ;
    long _b = b;
    return (_a * _b) / gcd_Euclidean(a,b);
  }

  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    //System.out.println(lcm_naive(a, b));
    System.out.println(lcm_fast(a, b));
  }
}
