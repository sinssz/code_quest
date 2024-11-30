const fn = (N, arr) => {
  const sumArr = arr.map((v) =>
    v
      .toString()
      .split("")
      .reduce((acc, curr) => acc + Number(curr), 0)
  );
  const maxV = Math.max(...sumArr);

  const maxVIndex = sumArr.reduce((acc, curr, idx) => {
    if (curr === maxV) return [...acc, idx];
    return acc;
  }, []);

  return Math.max(...arr.filter((v, idx) => maxVIndex.includes(idx)));
};

fn(7, [128, 460, 603, 40, 521, 137, 123]);
