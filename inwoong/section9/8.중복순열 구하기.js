const permutations = (n, m) => {
  const temp = Array(m).fill(0);
  const dfs = (level) => {
    if (level === m) {
      console.log(temp.join(" "));
      return;
    }
    for (let i = 1; i <= n; i++) {
      temp[level] = i;
      dfs(level + 1);
    }
  };

  dfs(0);
};

permutations(3, 2);
