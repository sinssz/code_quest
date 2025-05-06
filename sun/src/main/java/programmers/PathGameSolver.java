package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PathGameSolver {

    public int[][] solution(int[][] nodeinfo) {
        List<NodeInfo> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new NodeInfo(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        nodes.sort(Comparator
                .comparingInt(NodeInfo::getY).reversed()
                .thenComparingInt(NodeInfo::getX));

        BinaryTree tree = new BinaryTree();
        for (NodeInfo node : nodes) {
            tree.insert(node);
        }

        return new int[][]{
                tree.preorder(),
                tree.postorder()
        };
    }

    private static class NodeInfo {
        private final int x;
        private final int y;
        private final int index;

        public NodeInfo(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getIndex() {
            return index;
        }

    }

    private static class TreeNode {
        private final int x;
        private final int index;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int x, int index) {
            this.x = x;
            this.index = index;
        }

        public void insert(TreeNode node) {
            if (node.x < this.x) {
                if (left == null) {
                    left = node;
                } else {
                    left.insert(node);
                }
            } else {
                if (right == null) {
                    right = node;
                } else {
                    right.insert(node);
                }
            }
        }

        public int getIndex() {
            return index;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    private static class BinaryTree {
        private TreeNode root;

        public void insert(NodeInfo nodeInfo) {
            TreeNode node = new TreeNode(nodeInfo.getX(), nodeInfo.getIndex());
            if (root == null) {
                root = node;
            } else {
                root.insert(node);
            }
        }

        public int[] preorder() {
            List<Integer> result = new ArrayList<>();
            traversePre(root, result);
            return result.stream().mapToInt(i -> i).toArray();
        }

        public int[] postorder() {
            List<Integer> result = new ArrayList<>();
            traversePost(root, result);
            return result.stream().mapToInt(i -> i).toArray();
        }

        private void traversePre(TreeNode node, List<Integer> result) {
            if (node == null) return;
            result.add(node.getIndex());
            traversePre(node.getLeft(), result);
            traversePre(node.getRight(), result);
        }

        private void traversePost(TreeNode node, List<Integer> result) {
            if (node == null) return;
            traversePost(node.getLeft(), result);
            traversePost(node.getRight(), result);
            result.add(node.getIndex());
        }
    }
}
