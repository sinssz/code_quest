package section09;

// 재귀함수
public class RecursiveFunction {

    public static void main(String[] args) {
        dfs(3);
    }

    private static void dfs(int n) {
        if (n == 0) {
            return;
        }
        dfs(n - 1);
        System.out.println(n);
    }
}
