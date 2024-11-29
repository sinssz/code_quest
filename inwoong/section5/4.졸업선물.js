const fn = (N, M) => {
  const comboArr = [];
  for (let i = 0; i < N[0]; i++) {
    comboArr[i] = [M[i][0] / 2 + M[i][1]];
    for (let j = 0; j < N[0]; j++) {
      if (i !== j) comboArr[i].push(M[j][0] + M[j][1]);
    }
  }

  return Math.max(
    ...comboArr.map((v) => {
      v;
      let limitCash = N[1];
      while (limitCash > 0) {
        limitCash -= v.pop();
      }

      return N[0] - v.length;
    })
  );
};

fn(
  [5, 28],
  [
    [6, 6],
    [2, 2],
    [4, 3],
    [4, 5],
    [10, 3],
  ]
);
