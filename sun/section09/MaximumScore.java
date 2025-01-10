package section09;

// 최대점수 구하기(DFS)
public class MaximumScore {
    static int PROBLEM_COUNT = 5; // N
    static int TIME_LIMIT = 20; // M
    static int maxScore = 0;

    public static void main(String[] args) {
        int[] scores = {10, 25, 15, 6, 7};
        int[] times = {5, 12, 8, 3, 4};

        dfs(0, 0, 0, scores, times);
        System.out.println(maxScore);
    }

    private static void dfs(int index, int currentScore, int currentTime, int[] scores, int[] times) {
        if (currentTime > TIME_LIMIT) {
            return;
        }

        if (index == PROBLEM_COUNT) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // 현재 문제를 푸는 경우
        dfs(index + 1, currentScore + scores[index], currentTime + times[index], scores, times);

        // 현재 문제를 풀지 않는 경우
        dfs(index + 1, currentScore, currentTime, scores, times);
    }
}
