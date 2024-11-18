const fn = (N, score) => {
  const convertedScore = score.split(" ").map(Number);

  const obj = {};
  convertedScore
    .slice()
    .sort((a, b) => b - a)
    .forEach((v, idx) => {
      if (!obj[v]) obj[v] = idx + 1;
    });

  return convertedScore.map((v) => obj[v]);
};

fn(5, "87 89 92 100 76");
