const fn = (a, b) => {
  return [...a, ...b].sort((a, b) => a - b);
};

fn([1, 3, 5], [2, 3, 6, 7, 9]);
