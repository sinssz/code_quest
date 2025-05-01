package inflearn.section09;

// 부분집합 구하기(DFS)
public class Subsets {

    public static void main(String[] args) {
        int N = 3; // 예제 입력: 1부터 N까지의 원소를 갖는 집합
        generateSubsets(N);
    }

    public static void generateSubsets(int N) {
        int[] subset = new int[N + 1]; // 부분집합을 나타낼 배열 (1-based index 사용)
        dfs(1, N, subset); // 1부터 N까지 탐색 시작
    }

    private static void dfs(int level, int N, int[] subset) {
        if (level == N + 1) { // 모든 레벨을 탐색한 경우
            if (isNotEmpty(subset, N)) { // 공집합인지 확인
                printSubset(subset, N);
            }
        } else {
            // 현재 원소를 포함하는 경우
            subset[level] = 1;
            dfs(level + 1, N, subset);

            // 현재 원소를 포함하지 않는 경우
            subset[level] = 0;
            dfs(level + 1, N, subset);
        }
    }

    private static boolean isNotEmpty(int[] subset, int N) {
        for (int i = 1; i <= N; i++) {
            if (subset[i] == 1) {
                return true; // 하나라도 포함된 원소가 있다면 공집합이 아님
            }
        }
        return false; // 모든 원소가 포함되지 않은 경우 공집합
    }

    private static void printSubset(int[] subset, int N) {
        for (int i = 1; i <= N; i++) {
            if (subset[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
