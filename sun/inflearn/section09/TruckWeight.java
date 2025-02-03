package inflearn.section09;

// 바둑이 승차(DFS)
public class TruckWeight {
    static final int TRUCK_WEIGHT_LIMIT = 259;
    static int maxWeight = 0;

    public static void main(String[] args) {
        int[] weights = {81, 58, 42, 33, 61};

        dfs(0, 0, weights);
        System.out.println(maxWeight);
    }

    private static void dfs(int index, int currentWeight, int[] weights) {
        if (currentWeight > TRUCK_WEIGHT_LIMIT) {
            return;
        }

        maxWeight = Math.max(maxWeight, currentWeight);

        if (index == weights.length) {
            return;
        }

        // 현재 원소를 선택
        dfs(index + 1, currentWeight + weights[index], weights);

        // 현재 원소를 선택하지 않음
        dfs(index + 1, currentWeight, weights);
    }
}
