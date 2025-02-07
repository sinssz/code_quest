package inflearn.section06;

import java.util.Scanner;
import java.util.Stack;

/**
 * 크레인 인형뽑기(카카오)
 */
public class ClawMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] board =  new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack();

        for (int m : moves) {
            for (int row = 0; row < board.length; row ++) {
                if (board[row][m-1] == 0) {
                    continue;
                }

                int toy = board[row][m-1];
                board[row][m-1] = 0;

                if (basket.isEmpty() || basket.peek() != toy) {
                    basket.add(toy);
                } else {
                    basket.pop();
                    answer += 2;
                }
                break;
            }
        }

        return answer;
    }

    private static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack();

        for (int m : moves) {

            int row = 0;

            while (row < board.length && board[row][m-1] == 0) {
                row ++;
            }

            // 인형이 없는경우 -> 아무 동작하지 않음
            if (row == board.length) {
                continue;
            }

            if (basket.isEmpty() || basket.peek() != board[row][m-1]) {
                basket.add(board[row][m-1]);
            } else {
                basket.pop();
                answer += 2;
            }

            board[row][m-1] = 0;

        }

        return answer;
    }
}
