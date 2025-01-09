package section09;

// 합이 같은 부분집합(DFS: 아마존 인터뷰)
public class EqualSubsetSum {
    static String result = "NO"; // 결과를 저장하는 변수
    static int totalSum = 0; // 입력 배열의 전체 합
    static boolean found = false; // 정답을 찾으면 더 이상 탐색하지 않도록 설정

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 10};

        for (int i : arr) {
            totalSum += i;
        }

        dfs(0, 0, arr); // DFS 탐색 시작
        System.out.println(result);
    }

    private static void dfs(int index, int currentSum, int[] arr) {
        if (found) {
            return; // 이미 답을 찾은 경우 더 이상 탐색하지 않음
        }

        if (index == arr.length) { // 모든 원소를 탐색한 경우
            int remainingSum = totalSum - currentSum; // 현재 부분집합의 나머지 합
            if (currentSum == remainingSum) { // 두 부분집합의 합이 같은 경우
                result = "YES";
                found = true; // 정답을 찾았음을 표시
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        dfs(index + 1, currentSum + arr[index], arr);

        // 현재 원소를 포함하지 않는 경우
        dfs(index + 1, currentSum, arr);
    }
}
