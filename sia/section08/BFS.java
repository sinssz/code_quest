package section08;

import java.util.LinkedList;

/**
 * 이진트리 레벨 탐색 (BFS)
 */
public class BFS {
	Node node;

	static class Node {
		int data;
		Node lt;
		Node rt;

		public Node(int data) {
			this.data = data;
		}
	}

	public void BFS(Node node) {
		LinkedList<Node> nodes = new LinkedList<>();
		nodes.offer(node);

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			for (int i = 0; i < size; i++) {
				Node poll = nodes.poll();
				System.out.print(poll.data + " ");
				if (poll.lt != null) {
					nodes.offer(poll.lt);
				}
				if (poll.rt != null) {
					nodes.offer(poll.rt);
				}
			}
		}

	}

	public static void main(String[] args) {
		BFS tree = new BFS();
		tree.node = new Node(1);
		tree.node.lt = new Node(2);
		tree.node.rt = new Node(3);

		tree.node.lt.lt = new Node(4);
		tree.node.lt.rt = new Node(5);

		tree.node.rt.lt = new Node(6);
		tree.node.rt.rt = new Node(7);

		tree.BFS(tree.node);
	}
}
