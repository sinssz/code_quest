package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        int totalCost = 0;

        // 최소 두 개 이상 있어야 비교 가능
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            totalCost += sum;
            queue.add(sum); // 새로운 묶음을 다시 큐에 삽입
        }

        System.out.println(totalCost);
    }
}
