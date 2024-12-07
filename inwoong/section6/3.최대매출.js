const fn = (a, b) => {
  const comb = [];
  for (i = 0; i < a[0] - a[1] + 1; i++) {
    comb.push(b.slice(i, i + a[1]).reduce((acc, curr) => acc + curr));
  }

  return Math.max(...comb);
};

fn([10, 3], [12, 15, 11, 20, 25, 10, 20, 19, 13, 15]);
