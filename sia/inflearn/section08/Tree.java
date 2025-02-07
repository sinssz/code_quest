package inflearn.section08;

/**
 * 이진트리순회(DFS)
 */
public class Tree {
	Node root;

	static class Node {
		int data;
		Node lt;
		Node rt;

		public Node(int val) {
			this.data = val;
			this.lt = this.rt = null;
		}
	}

	public void DFS(Node root) {
		if (root == null) return;
		else {
			System.out.print(root.data + " ");
			DFS(root.lt);
			DFS(root.rt);
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);

		tree.DFS(tree.root);
	}
}


