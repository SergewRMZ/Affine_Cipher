package escom.app_euclides.src.modules;
public class MathUtils {
  public static long[] extendedGcd(long a, long b) {
    if (b == 0) {
      return a > 0 ? new long[]{a, 1, 0} : new long[]{-a, -1, 0};
    } else {
      long[] result = extendedGcd(b, a % b);
      long d = result[0];
      long x = result[1];
      long y = result[2];
      return new long[]{d, y, x - y * (a / b)};
    }
  }
  
  public static long modularInverse(long a, long n) {
    long[] result = extendedGcd(a, n);
    long d = result[0];
    long x = result[1];
    if (d != 1) return -1;
    if (x < 0) x += n;
    return x;
  }
  
  public static boolean isInInterval(long a, long n){
    return (a > 0 && a <= n);
  }

  public static boolean isValid(long a, long n){
    long[] result = extendedGcd(a, n);
    long d = result[0];
    return d == 1;
  }
}
