const factorial = (n) => {
  const dfs = (num) => (num === 1 ? 1 : num * dfs(num - 1));
  console.log(dfs(n));
};

factorial(5);
