package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2751 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, temp, 0, arr.length - 1);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        System.out.println(Arrays.toString(arr));
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int part1 = left;
        int part2 = mid + 1;
        int index = left;

        while (part1 <= mid && part2 <= right) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        while (part1 <= mid) {
            arr[index++] = temp[part1++];
        }
    }
}
