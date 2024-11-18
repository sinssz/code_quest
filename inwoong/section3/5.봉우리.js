const fn = (N, board) => {
  const peaks = [];

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      const top = board[i][j] > (board[i - 1]?.[j] ?? 0);
      const left = board[i][j] > (board[i][j - 1] ?? 0);
      const right = board[i][j] > (board[i][j + 1] ?? 0);
      const bottom = board[i][j] > (board[i + 1]?.[j] ?? 0);

      if (top && left && right && bottom) peaks.push(board[i][j]);
    }
  }

  return peaks.length;
};

fn(5, [
  [5, 3, 7, 2, 3],
  [3, 7, 1, 6, 1],
  [7, 2, 5, 3, 4],
  [4, 3, 6, 4, 1],
  [8, 7, 3, 5, 2],
]);
