package inflearn.section10;

import java.util.Scanner;

/**
 * 친구인가? (Union&Find)
 */
public class UnionAndFind {
	static int[] root;
	static int n;
	static int m;

	// 특정 노드의 루트 노드를 찾는 메서드
	private static int findRoot(int v) {
		if (root[v] == v)
			return v;
		// 거쳐간 모든 노드의 집합을 갱신
		return root[v] = findRoot(root[v]);
	}

	// 두 노드를 같은 집합으로 합치는 메서드
	private static void union(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		//두 노드가 서로 다른 집합에 속하는 경우 그들을 같은 집합으로 합침 -> 인덱스가 작은 노드를 root로
		if (a < b)  {
			root[rootB] = rootA;
		}
		else{
			root[rootA] = rootB;
		}
		//if (rootA != rootB) root[rootB] = rootA;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		root = new int[n + 1];

		// 초기화
		for (int i = 1; i < n + 1; i++) {
			root[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			union(a,b);
		}

		// 같은 루트노드 인지 확인
		int a = findRoot(scanner.nextInt());
		int b = findRoot(scanner.nextInt());

		System.out.println(a == b ? "YES" : "NO");
	}
}
