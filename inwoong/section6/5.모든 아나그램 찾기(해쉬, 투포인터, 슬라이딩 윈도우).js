const fn = (S, T) => {
  let count = 0;
  const convertedS = S.split("");
  const convertedT = T.split("");
  for (let i = 0; i < S.length - T.length + 1; i++) {
    if (
      convertedS
        .slice(i, i + T.length)
        .sort()
        .join("") === convertedT.sort().join("")
    )
      count += 1;
  }

  return count;
};

fn("bacaAacba", "abc");
