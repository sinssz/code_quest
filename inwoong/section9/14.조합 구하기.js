const getCombinations = (n, m) => {
  const result = [];
  const temp = Array(m).fill(0);

  const dfs = (level, start) => {
    if (level === m) {
      console.log(temp.join(" "));
      result.push([...temp]);
      return;
    }
    for (let i = start; i <= n; i++) {
      temp[level] = i;
      dfs(level + 1, i + 1);
    }
  };

  dfs(0, 1);
  console.log(result.length);
};

getCombinations(4, 2);
