package inflearn.section09;

public class RepeatedPermutations {
    static int N, M;
    static int[] result;
    static int count = 0;

    public static void main(String[] args) {
        N = 4; // 1부터 N까지의 숫자
        M = 3; // 뽑는 개수

        result = new int[M]; // 결과 저장 배열 초기화

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int level) {
        if (level == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }

            System.out.println();
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[level] = i;
            dfs(level + 1);
        }
    }
}
