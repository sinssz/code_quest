const maxWeight = (c, weights) => {
  let max = 0;

  const dfs = (index, sum) => {
    if (sum > c) return;
    if (index === weights.length) {
      max = Math.max(max, sum);
      return;
    }
    dfs(index + 1, sum + weights[index]);
    dfs(index + 1, sum);
  };

  dfs(0, 0);
  console.log(max);
};

maxWeight(259, [81, 58, 42, 33, 61]);
