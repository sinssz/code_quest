package section09;

// 팩토리얼
public class Factorial {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(factorial(N));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
