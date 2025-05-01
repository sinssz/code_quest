package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343 {
    static int N, M;
    static int[] lessons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessons = new int[N];

        int left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lessons[i]);
            right += lessons[i];
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (countBulRays(mid) <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static int countBulRays(int size) {
        int count = 1;
        int sum = 0;
        for (int lesson : lessons) {
            if (sum + lesson > size) {
                count++;
                sum = lesson;
            } else {
                sum += lesson;
            }
        }

        return count;
    }
}
