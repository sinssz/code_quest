const solution = (arr) => {
  let result = 0;

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      const current = arr[i][j]; // 현재 봉우리

      const map = [
        arr[i]?.[j - 1] ?? 0,
        arr[i + 1]?.[j] ?? 0,
        arr[i - 1]?.[j] ?? 0,
        arr[i]?.[j + 1] ?? 0,
      ];
      const hightest = Math.max(...map);
      if (hightest <= current) {
        result += 1;
      }
    }
  }
  return result;
};

console.log(
  solution([
    [5, 3, 7, 2, 3],
    [3, 7, 1, 6, 1],
    [7, 2, 5, 3, 4],
    [4, 3, 6, 4, 1],
    [8, 7, 3, 5, 2],
  ])
);
