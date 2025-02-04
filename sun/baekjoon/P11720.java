package baekjoon;

import java.util.Scanner;

public class P11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();

        int sum = 0;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            sum += Character.getNumericValue(c);
        }

        System.out.println(sum);
    }
}
