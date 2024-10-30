package escom.app_euclides.src.modules;

import javax.swing.JOptionPane;

public class EncryptionService {
  public static String cipherFunction (long a, long b, long n) {
    return "C = (" + a + " p + " + b + ") mod " + n;
  }
  
  public static String decipherFunction(long a, long b, long n) {
    long inverse = MathUtils.modularInverse(a, n);
    if (inverse == -1) {
      return null;
    }
    long b_adInverse = n - b;
    return "p = " + inverse + "(C + " + b_adInverse + ") mod " + n;
  }
}
