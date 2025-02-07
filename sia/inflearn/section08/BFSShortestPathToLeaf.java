package inflearn.section08;

import java.util.LinkedList;

/**
 * Tree 말단노드까지의 가장 짧은 경로 (BFS)
 */
public class BFSShortestPathToLeaf {
	Node root;

	static class Node {
		private int root;
		private Node left;
		private Node right;

		public Node(int root) {
			this.root = root;
			this.left = this.right = null;
		}
	}

	public int BFS() {
		int level = 0;
		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(this.root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node node = queue.poll();

				// 말단 노드
				if (node.left == null && node.right == null) {
					return level;
				}

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
		}

		return level;

	}

	public static void main(String[] args) {
		BFSShortestPathToLeaf tree = new BFSShortestPathToLeaf();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		int bfs = tree.BFS();
		System.out.println(bfs);
	}
}
