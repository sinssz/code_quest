package section06;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호 문자 제거
 */
public class ParenthesesStringRemover {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        System.out.println(solution(input));
    }

    private static String solution(char[] input) {
        StringBuilder answer = new StringBuilder();
        Stack bracket = new Stack();
        
        for (char c : input) {

            if (c == '(') {
                bracket.add(c);
                continue;
            }

            if (c == ')') {
                bracket.pop();
                continue;
            }

            if (bracket.isEmpty()) {
                answer.append(c);
            }
            
        }

        return answer.toString();
    }
    
}
