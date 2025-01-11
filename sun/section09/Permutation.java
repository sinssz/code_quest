package section09;

// 순열 구하기
public class Permutation {
    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        N = 4; // 자연수 개수
        M = 2; // 선택 개수
        arr = new int[]{3, 6, 9, 10};
        visited = new boolean[N];
        selected = new int[M];


        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            // 선택된 순열 출력
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                selected[depth] = arr[i]; // 현재 숫자 선택
                dfs(depth + 1); // 다음 깊이 탐색
                visited[i] = false; // 백트래킹: 방문 해제
            }
        }
    }
}
