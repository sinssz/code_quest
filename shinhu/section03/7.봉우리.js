const solution = (arr) => {
  const n = arr.length;
  let result = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      me = arr[i][j];
      top = i - 1 >= 0 ? arr[i - 1][j] : 0;
      bottom = i + 1 < n ? arr[i + 1][j] : 0;
      left = j - 1 >= 0 ? arr[i][j - 1] : 0;
      right = j + 1 < n ? arr[i][j + 1] : 0;
      if (Math.max(me, top, bottom, left, right) === me) {
        result++;
      }
    }
  }
  console.log(result);
};

solution([
  [5, 3, 7, 2, 3],
  [3, 7, 1, 6, 1],
  [7, 2, 5, 3, 4],
  [4, 3, 6, 4, 1],
  [8, 7, 3, 5, 2],
]);
