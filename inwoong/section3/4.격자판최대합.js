const fn = (N, board) => {
  const sum = []; // 각 조건 별 합산 값 모음
  const crossV = []; // 대각선 값 모음
  const reverseCrossV = []; // 역대각선 값 모음
  for (let i = 0; i < N; i++) {
    reverseCrossV.push(board[i][N - 1 - i]);

    sum.push(board[i].reduce((acc, curr) => curr + acc));

    const columnV = []; // 열 값 모음
    for (let j = 0; j < N; j++) {
      if (i === j) crossV.push(board[i][j]);
      columnV.push(board[j][i]);
    }

    sum.push(columnV.reduce((acc, curr) => acc + curr));
  }

  sum.push(crossV.reduce((acc, curr) => acc + curr));
  sum.push(reverseCrossV.reduce((acc, curr) => acc + curr));

  return Math.max(...sum);
};

fn(5, [
  [10, 13, 10, 12, 15],
  [12, 39, 30, 23, 11],
  [11, 25, 50, 53, 15],
  [19, 27, 29, 37, 27],
  [19, 13, 30, 13, 19],
]);
