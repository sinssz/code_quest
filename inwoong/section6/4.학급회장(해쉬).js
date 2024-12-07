const fn = (a) => {
  const list = {};
  a.forEach((v) => {
    list[v] = (list[v] ?? 0) + 1;
  });
  return Object.entries(list).sort((a, b) => b[1] - a[1])[0][0];
};

fn(["B", "A", "C", "B", "A", "C", "C", "A", "C", "C", "B", "D", "E", "D", "E"]);
