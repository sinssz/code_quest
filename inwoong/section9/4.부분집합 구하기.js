const subsets = (n) => {
  const subset = [];
  const dfs = (level) => {
    if (level === n + 1) {
      if (subset.length > 0) console.log(subset.join(" "));
      return;
    }
    subset.push(level);
    dfs(level + 1);
    subset.pop();
    dfs(level + 1);
  };
  dfs(1);
};

subsets(3);
