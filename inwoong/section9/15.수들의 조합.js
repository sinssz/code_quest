const combinationsSumDivisible = (n, k, arr, m) => {
  let count = 0;
  const temp = Array(k).fill(0);

  const dfs = (level, start, sum) => {
    if (level === k) {
      if (sum % m === 0) count++;
      return;
    }
    for (let i = start; i < n; i++) {
      temp[level] = arr[i];
      dfs(level + 1, i + 1, sum + arr[i]);
    }
  };

  dfs(0, 0, 0);
  console.log(count);
};

combinationsSumDivisible(5, 3, [2, 4, 5, 8, 12], 6);
