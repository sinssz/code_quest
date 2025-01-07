package section09;

// 이진트리 순회
public class BinaryTree {

    public static void main(String[] args) {
        int n = 1;
        printPreorder(n);
        System.out.println();
        printInorder(n);
        System.out.println();
        printPostorder(n);
    }

    private static void printPreorder(int n) {
        if (n > 7) {
            return;
        }

        System.out.print(n + " ");
        printPreorder(n * 2);
        printPreorder(n * 2 + 1);
    }

    private static void printInorder(int n) {
        if (n > 7) {
            return;
        }

        printInorder(n * 2);
        System.out.print(n + " ");
        printInorder(n * 2 + 1);
    }

    private static void printPostorder(int n) {
        if (n > 7) {
            return;
        }

        printPostorder(n * 2);
        printPostorder(n * 2 + 1);
        System.out.print(n + " ");
    }

}
