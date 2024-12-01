const solution = (arr) => {
  const m = arr.length;
  const n = arr[0].length;
  const result = [];

  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      let cnt = 0;
      for (let k = 0; k < m; k++) {
        let tempi = 0;
        let tempj = 0;
        for (let l = 0; l < n; l++) {
          if (arr[k][l] === i) tempi = l;
          if (arr[k][l] === j) tempj = l;
        }

        if (tempi < tempj) {
          cnt++;
        }
      }

      if (cnt === m) {
        result.push([i, j]);
      }
    }
  }

  return result;
};

console.log(
  solution([
    [3, 4, 1, 2],
    [4, 3, 2, 1],
    [3, 1, 4, 2],
  ])
);
