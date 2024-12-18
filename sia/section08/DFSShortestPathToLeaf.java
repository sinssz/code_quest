package section08;



public class DFSShortestPathToLeaf {
	Node root;

	static class Node {
		private int data;
		private Node lf;
		private Node rf;

		public Node(int val) {
			this.data = val;
			this.lf = this.rf = null;
		}

		public boolean isLeaf() {
			return this.lf == null && this.rf == null;
		}
	}

	public int DFS(int l, Node root) {
		if (root.isLeaf()) return l;
		else return Math.min(DFS(l+1, root.lf), DFS(l+1, root.rf));
	}

	public static void main(String[] args) {
		DFSShortestPathToLeaf tree = new DFSShortestPathToLeaf();
		tree.root = new Node(1);
		tree.root.lf = new Node(2);
		tree.root.rf = new Node(3);
		tree.root.lf.lf = new Node(4);
		tree.root.lf.rf = new Node(5);

		System.out.println(tree.DFS(0, tree.root));

	}
}
