package inflearn.section06;

// 최대 매출
public class MaximumSales {

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};

		System.out.println(solution(n, k, arr));
	}

	private static int solution(int n, int k, int[] arr) {
		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		int result = sum;

		for (int i = k; i < n; i++) {
			sum += arr[i];
			sum -= arr[i - k];
			result = Math.max(result, sum);
		}
		
		return result;
	}

}
