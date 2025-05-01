package inflearn.section09;

import java.util.Arrays;

// 수열 추측하기
public class PascalTriangle {
    static int[][] dy = new int[11][11]; // 조합 값을 저장하는 배열
    static int[] ch; // 체크 배열
    static int[] p;  // 순열 저장 배열
    static int[] b;  // 조합 값 저장 배열
    static int n, f; // n: 숫자 개수, f: 목표 값
    static boolean flag = false; // 답을 찾았는지 여부
    static int[] answer; // 정답 배열

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 18)));
    }

    public static int[] solution(int N, int F) {
        n = N;
        f = F;
        ch = new int[n + 1];
        p = new int[n];
        b = new int[n];

        // 조합 값 미리 계산
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }

        // DFS 호출
        DFS(0, 0);
        return answer;
    }

    // 조합 계산 메서드
    public static int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    // DFS를 활용한 탐색
    public static void DFS(int L, int sum) {
        if (flag) return; // 이미 답을 찾았으면 종료
        if (L == n && sum == f) { // 정답 조건
            answer = p.clone();
            flag = true;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) { // 아직 사용하지 않은 숫자라면
                    ch[i] = 1; // 사용 처리
                    p[L] = i; // 순열에 추가
                    DFS(L + 1, sum + (b[L] * p[L])); // 다음 레벨 탐색
                    ch[i] = 0; // 백트래킹
                }
            }
        }
    }
}
