const fn = (board, moves) => {
  const stack = [];
  let count = 0;
  moves.forEach((v) => {
    let i = 0;

    while (!board[i][v - 1]) {
      i += 1;
      if (i === board.length - 1) break;
    }

    const doll = board[i][v - 1];
    if (stack[stack.length - 1] === doll) {
      stack.pop();
      count += 2;
    } else stack.push(doll);
    board[i][v - 1] = 0;
  });

  return count;
};

fn(
  [
    [0, 0, 0, 0, 0],
    [0, 0, 1, 0, 3],
    [0, 2, 5, 0, 1],
    [4, 2, 4, 4, 2],
    [3, 5, 1, 3, 1],
  ],
  [1, 5, 3, 5, 1, 2, 1, 4]
);
