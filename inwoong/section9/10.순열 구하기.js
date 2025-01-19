const getPermutations = (arr, m) => {
  const result = [];
  const temp = Array(m).fill(0);
  const visited = Array(arr.length).fill(false);

  const dfs = (level) => {
    if (level === m) {
      console.log(temp.join(" "));
      result.push([...temp]);
      return;
    }
    for (let i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        temp[level] = arr[i];
        dfs(level + 1);
        visited[i] = false;
      }
    }
  };

  dfs(0);
};

getPermutations([3, 6, 9], 2);
