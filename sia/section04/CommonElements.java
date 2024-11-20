package section04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 공통원소 구하기
 */
public class CommonElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 첫번째 Array
		int n = scanner.nextInt();
		int[] nArray = new int[n];
		for (int i = 0; i < n; i++) {
			nArray[i] = scanner.nextInt();
		}

		// 두번째 Array
		int m = scanner.nextInt();
		int[] mArray = new int[m];
		for (int i = 0; i < n; i++) {
			mArray[i] = scanner.nextInt();
		}

		//정답값 출력
		for (int i : solution(n,nArray,m,mArray)) {
			System.out.print(i + " ");
		}
	}

	public static List<Integer> solution(int n, int[] nArray, int m, int[] mArray) {
		// 오름차순으로 정렬
		Arrays.sort(nArray);
		Arrays.sort(mArray);

		List<Integer> answer = new ArrayList<>();

		int nPointer = 0;
		int mPointer = 0;

		while (nPointer < n && mPointer < m) {
			// 공통 원소를 찾으면, 답 추가 후 각각의 포인터 +1
			if (nArray[nPointer] == mArray[mPointer]) {
				answer.add(nArray[nPointer]);
				nPointer ++;
				mPointer ++;
				continue;
			}
			// 포인터가 가르키는 값이 다른 경우
			// 더 작은 값을 가르키는 포인터를 증가시킨다. (오름차순이므로)
			if (nArray[nPointer] < mArray[mPointer]) {
				nPointer ++;
			}

			if (nArray[nPointer] > mArray[mPointer]) {
				mPointer ++;
			}
		}

		return answer;
	}
}
