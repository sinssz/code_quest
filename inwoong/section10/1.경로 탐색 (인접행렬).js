const pathCountMatrix = (n, edges) => {
  const graph = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
  const visited = Array(n + 1).fill(false);
  let count = 0;

  edges.forEach(([from, to]) => (graph[from][to] = 1));

  const dfs = (node) => {
    if (node === n) {
      count++;
      return;
    }
    for (let i = 1; i <= n; i++) {
      if (graph[node][i] && !visited[i]) {
        visited[i] = true;
        dfs(i);
        visited[i] = false;
      }
    }
  };

  visited[1] = true;
  dfs(1);
  console.log(count);
};

pathCountMatrix(5, [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 1],
  [2, 3],
  [2, 5],
  [3, 4],
  [4, 2],
  [4, 5],
]);
