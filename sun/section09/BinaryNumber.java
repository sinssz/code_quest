package section09;

// 재귀함수를 이용한 이진수 출력
public class BinaryNumber {

    public static void main(String[] args) {
        printBinaryNumber(10);
    }

    private static void printBinaryNumber(int n) {
        if (n == 0) {
            return;
        }
        printBinaryNumber(n / 2);
        System.out.print(n % 2);
    }
}
