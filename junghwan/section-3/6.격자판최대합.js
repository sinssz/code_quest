const solution = (arr) => {
  let answer = Number.MIN_SAFE_INTEGER;
  let rowSum = 0,
    columnSum = 0,
    leftCrossSum = 0,
    rightCrossSum = 0;

  for (let i = 0; i < arr.length; i++) {
    rowSum = 0;
    columnSum = 0;
    for (let j = 0; j < arr.length; j++) {
      rowSum += arr[i][j];
      columnSum += arr[j][i];
    }
    answer = Math.max(answer, rowSum, columnSum);
  }
  for (let i = 0; i < arr.length; i++) {
    leftCrossSum += arr[i][i];
    rightCrossSum += arr[i][arr.length - i - 1];
  }
  answer = Math.max(answer, leftCrossSum, rightCrossSum);
  return answer;
};

console.log(
  solution([
    [10, 13, 10, 12, 15],
    [12, 39, 30, 23, 11],
    [11, 25, 50, 53, 15],
    [19, 27, 29, 37, 27],
    [19, 13, 30, 13, 19],
  ])
);
