const fn = (N, M) => {
  const comboArr = [];
  for (i = 0; i < M.length; i++) {
    for (j = i + 1; j < M.length; j++) {
      for (k = j + 1; k < M.length; k++) {
        comboArr.push(M[i] + M[j] + M[k]);
      }
    }
  }

  return comboArr.sort((a, b) => b - a)[N[1] - 1];
};

fn([10, 3], [13, 15, 34, 23, 45, 65, 33, 11, 26, 42]);
