package clear.code;

public class MathOperations {
    public int addNumbers(int... numbers) {
        int totalSum = 0;
        for (int n : numbers) {
            totalSum += n;
        }
        return totalSum;

    }

    public static void main(String[] args) {
        MathOperations sum = new MathOperations();
        System.out.println(sum.addNumbers(1, 99));
        System.out.println(sum.addNumbers(1, 99, 100));
        System.out.println(sum.addNumbers(1, 99, 100, 2));
    }

}
