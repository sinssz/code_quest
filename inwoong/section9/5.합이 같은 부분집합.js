const isSubsetEqualSum = (arr) => {
  const total = arr.reduce((a, b) => a + b, 0);
  let found = false;

  const dfs = (index, sum) => {
    if (found) return;
    if (sum > total / 2) return;
    if (index === arr.length) {
      if (sum * 2 === total) found = true;
      return;
    }
    dfs(index + 1, sum + arr[index]);
    dfs(index + 1, sum);
  };

  dfs(0, 0);
  console.log(found ? "YES" : "NO");
};

isSubsetEqualSum([1, 3, 5, 6, 7, 10]);
