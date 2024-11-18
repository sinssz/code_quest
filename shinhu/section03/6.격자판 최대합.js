const solution = (arr) => {
  const n = arr.length;
  let result = 0;
  // 가로합
  for (let i = 0; i < arr.length; i++) {
    let horizontalSum = 0;
    let verticalSum = 0;
    for (let j = 0; j < arr.length; j++) {
      horizontalSum += arr[i][j];
      verticalSum += arr[j][i];
    }

    result = Math.max(horizontalSum, verticalSum);
  }
  // 대각선합
  let leftDiagonalSum = 0;
  let rightDiagonalSum = 0;
  for (let i = 0; i < n; i++) {
    leftDiagonalSum += arr[i][i];
    rightDiagonalSum += arr[i][n - 1 - i];
  }
  result = Math.max(result, leftDiagonalSum, rightDiagonalSum);

  console.log(result);
};

solution([
  [10, 13, 10, 12, 15],
  [12, 39, 30, 23, 11],
  [11, 25, 50, 53, 15],
  [19, 27, 29, 37, 27],
  [19, 13, 30, 13, 19],
]);
