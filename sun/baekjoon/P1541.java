package baekjoon;

import java.util.Scanner;

public class P1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();

        // - 기호로 나누고, 각 부분에서 + 기호를 처리
        String[] minusParts = expression.split("-");

        int result = 0;

        for (int i = 0; i < minusParts.length; i++) {
            // 만약 -로 나눠진 첫 번째 부분이라면 그냥 더해준다
            if (i == 0) {
                result += calculateSum(minusParts[i]);
            } else {
                result -= calculateSum(minusParts[i]);
            }
        }

        System.out.println(result);
    }

    // +가 포함된 부분을 처리하는 메소드
    private static int calculateSum(String part) {
        int sum = 0;
        String[] plusParts = part.split("\\+");
        for (String s : plusParts) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
