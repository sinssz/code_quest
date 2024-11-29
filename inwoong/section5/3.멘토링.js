const fn = (N, M) => {
  const comboArr = [];
  for (let i = 1; i <= N[0]; i++) {
    for (let j = 1; j <= N[0]; j++) {
      if (i !== j) comboArr.push(Number(`${i}${j}`));
    }
  }

  const impossibleComboArr = [];
  M.forEach((test) => {
    while (test.length > 1) {
      const num = test.pop();
      test.forEach((score) => {
        impossibleComboArr.push(Number(`${num}${score}`));
      });
    }
  });

  return comboArr.filter((v) => !impossibleComboArr.includes(v)).length;
};

fn(
  [4, 3],
  [
    [3, 4, 1, 2],
    [4, 3, 2, 1],
    [3, 1, 4, 2],
  ]
);
