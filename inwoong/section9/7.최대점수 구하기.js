const maxScore = (problems, m) => {
  let max = 0;

  const dfs = (index, score, time) => {
    if (time > m) return;
    if (index === problems.length) {
      max = Math.max(max, score);
      return;
    }
    dfs(index + 1, score + problems[index][0], time + problems[index][1]);
    dfs(index + 1, score, time);
  };

  dfs(0, 0, 0);
  console.log(max);
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
