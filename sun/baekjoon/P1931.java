package baekjoon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1931 {
    static List<List<Integer>> graph;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 회의 정보 저장
        int[][] meetings = new int[N][2];

        // 회의 시간 입력 받기
        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt();  // 시작 시간
            meetings[i][1] = sc.nextInt();  // 끝나는 시간
        }

        // 끝나는 시간이 빠른 순으로 정렬
        Arrays.sort(meetings, (s, e) -> {
            if (s[1] == e[1]) {
                return s[0] - e[0];
            }

            return s[1] - e[1];
        });

        int count = 0;
        int lastEndTime = 0;

        // 회의 배정
        for (int i = 0; i < N; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            // 이전 회의의 끝나는 시간보다 현재 회의의 시작 시간이 크거나 같다면
            // 회의를 배정할 수 있음
            if (startTime >= lastEndTime) {
                count++;
                lastEndTime = endTime;  // 현재 회의의 끝나는 시간으로 갱신
            }
        }

        System.out.println(count);  // 최대 회의 수 출력
    }
}
