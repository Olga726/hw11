package practice11;

public class BiggestDivider {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
