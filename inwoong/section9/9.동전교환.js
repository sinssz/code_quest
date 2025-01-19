const coinChange = (coins, target) => {
  let minCount = target;

  const dfs = (sum, count) => {
    if (sum > target) return;
    if (sum === target) {
      minCount = Math.min(minCount, count);
      return;
    }
    for (let coin of coins) {
      dfs(sum + coin, count + 1);
    }
  };

  dfs(0, 0);
  console.log(minCount === target ? -1 : minCount);
};

coinChange([1, 2, 5], 15);
