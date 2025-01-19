const sequenceGuess = (n, f) => {
  const combination = (n, r) => {
    const memo = Array.from({ length: n + 1 }, () => Array(r + 1).fill(-1));
    const dfs = (n, r) => {
      if (r === 0 || r === n) return 1;
      if (memo[n][r] !== -1) return memo[n][r];
      return (memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r));
    };
    return dfs(n, r);
  };

  const coeff = Array.from({ length: n }, (_, i) => combination(n - 1, i));
  const visited = Array(n + 1).fill(false);
  const result = [];
  let found = false;

  const dfs = (level, sum) => {
    if (found) return;
    if (level === n) {
      if (sum === f) {
        console.log(result.join(" "));
        found = true;
      }
      return;
    }
    for (let i = 1; i <= n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[level] = i;
        dfs(level + 1, sum + coeff[level] * i);
        visited[i] = false;
      }
    }
  };

  dfs(0, 0);
};

sequenceGuess(4, 16);
