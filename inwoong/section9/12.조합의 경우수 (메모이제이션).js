const combination = (n, r) => {
  const memo = Array.from({ length: n + 1 }, () => Array(r + 1).fill(-1));

  const dfs = (n, r) => {
    if (r === 0 || r === n) return 1;
    if (memo[n][r] !== -1) return memo[n][r];
    return (memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r));
  };

  console.log(dfs(n, r));
};

combination(5, 3);
combination(33, 19);
