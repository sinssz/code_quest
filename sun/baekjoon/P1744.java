package baekjoon;

import java.util.*;

public class P1744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                zeros++;
            }

            if (num == 1) {
                ones++;
            }

            if (num > 1) {
                positives.add(num);
            }

            if (num < 1) {
                negatives.add(num);
            }
        }

        positives.sort(Collections.reverseOrder());
        Collections.sort(negatives);

        int totalCost = 0;

        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                totalCost += positives.get(i) * positives.get(i + 1);
            } else {
                totalCost += positives.get(i);
            }
        }

        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                totalCost += negatives.get(i) * negatives.get(i + 1);
            } else if (zeros == 0) {
                totalCost += negatives.get(i);
            }
        }

        totalCost += ones;

        System.out.println(totalCost);
    }
}
