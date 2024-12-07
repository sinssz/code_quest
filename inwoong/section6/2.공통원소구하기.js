const fn = (a, b) => {
  return a.filter((v) => b.includes(v)).sort((a, b) => a - b);
};

fn([1, 3, 9, 5, 2], [3, 2, 5, 7, 8]);
