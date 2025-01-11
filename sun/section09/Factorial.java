package section09;

// 팩토리얼
public class Factorial {
    static int result = 1;

    public static void main(String[] args) {
        int N = 4;
        dfs(N);
        System.out.println(result);
    }

    private static void dfs(int N) {
        if (N == 1) {
            return;
        }

        result = result * N;
        dfs(N - 1);
    }
}
