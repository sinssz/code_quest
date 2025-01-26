const coinChange = (coins, target) => {
  const dp = Array(target + 1).fill(target + 1);
  dp[0] = 0;

  for (let coin of coins) {
    for (let j = coin; j <= target; j++) {
      dp[j] = Math.min(dp[j], dp[j - coin] + 1);
    }
  }

  return dp[target] === target + 1 ? -1 : dp[target];
};
coinChange([1, 2, 5], 15);
