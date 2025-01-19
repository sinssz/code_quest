const pathCountList = (n, edges) => {
  const graph = Array.from({ length: n + 1 }, () => []);
  const visited = Array(n + 1).fill(false);
  let count = 0;

  edges.forEach(([from, to]) => graph[from].push(to));

  const dfs = (node) => {
    if (node === n) {
      count++;
      return;
    }
    for (let next of graph[node]) {
      if (!visited[next]) {
        visited[next] = true;
        dfs(next);
        visited[next] = false;
      }
    }
  };

  visited[1] = true;
  dfs(1);
  console.log(count);
};

pathCountList(5, [
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
