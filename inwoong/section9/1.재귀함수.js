const printNumbers = (n) => {
  const dfs = (current) => {
    if (current > n) return;
    console.log(current);
    dfs(current + 1);
  };
  dfs(1);
};
