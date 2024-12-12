const solution = (board, moves) => {
  const len = board.length;
  const basket = [];
  let boomCnt = 0;

  for (let i = 0; i < moves.length; i++) {
    for (let j = 0; j < len; j++) {
      const doll = board[j][i - 1];

      // 비어있는곳
      if (!doll) {
        continue;
      }

      if (basket[basket.length - 1] === doll) {
        boomCnt += 2;
        basket.pop();
      } else {
        basket.push(doll);
      }
    }
  }

  return boomCnt;
};

console.log(
  solution(
    [
      [0, 0, 0, 0, 0],
      [0, 0, 1, 0, 3],
      [0, 2, 5, 0, 1],
      [4, 2, 4, 4, 2],
      [3, 5, 1, 3, 1],
    ],
    [1, 5, 3, 5, 1, 2, 1, 4]
  )
);
