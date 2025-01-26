const maxScore = (problems, timeLimit) => {
  const dp = Array(timeLimit + 1).fill(0);
  for (let [score, time] of problems) {
    for (let t = timeLimit; t >= time; t--) {
      dp[t] = Math.max(dp[t], dp[t - time] + score);
    }
  }
  return Math.max(...dp);
};

maxScore(
  [
    [10, 5],
    [25, 12],
    [15, 8],
    [6, 3],
    [7, 4],
  ],
  20
);
