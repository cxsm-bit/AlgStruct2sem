//ЗИТ-251 Сущенко Д.С. Номер зачётки 257453, вариант 3
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    // Возвращает пару (F(n), F(n+1)) используя fast doubling
    private static BigInteger[] fibPair(long n) {
        if (n == 0) return new BigInteger[] { BigInteger.ZERO, BigInteger.ONE };
        BigInteger[] half = fibPair(n >> 1);
        BigInteger a = half[0]; // F(k)
        BigInteger b = half[1]; // F(k+1)

        BigInteger twoB = b.shiftLeft(1); // 2*b
        BigInteger c = a.multiply(twoB.subtract(a)); // F(2k)
        BigInteger d = a.multiply(a).add(b.multiply(b)); // F(2k+1)

        if ((n & 1) == 0) {
            return new BigInteger[] { c, d };
        } else {
            return new BigInteger[] { d, c.add(d) };
        }
    }

    // Возвращает F(n)
    private static BigInteger fib(long n) {
        return fibPair(n)[0];
    }

    // Находит цифру с максимальным вхождением и число таких вхождений.
    // Если несколько цифр имеют одинаковой максимальной частотой — возвращает наибольшую цифру.
    private static int[] mostFrequentDigit(BigInteger num) {
        String s = num.toString();
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }

        int bestDigit = 0;
        int bestCount = 0;
        for (int d = 0; d <= 9; d++) {
            if (cnt[d] > bestCount || (cnt[d] == bestCount && d > bestDigit)) {
                bestCount = cnt[d];
                bestDigit = d;
            }
        }
        return new int[] { bestDigit, bestCount };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите i (10..100000): ");
        if (!sc.hasNextLong()) {
            System.out.println("Ожидалось целое число.");
            return;
        }
        long i = sc.nextLong();
        if (i < 10 || i > 100000) {
            System.out.println("i должно быть в диапазоне 10..100000");
            return;
        }

        BigInteger fi = fib(i);
        int[] res = mostFrequentDigit(fi);

        System.out.println("F(" + i + ") имеет " + fi.toString().length() + " цифр.");
        System.out.println("Результат: [(" + res[1] + ", " + res[0] + ")]");
        System.out.println("(число вхождений = " + res[1] + ", цифра = " + res[0] + ")");
    }
}