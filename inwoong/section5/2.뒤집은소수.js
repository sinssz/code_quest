const fn = (N, arr) => {
  const reversedArr = arr.map((v) =>
    Number(
      v
        .toString()
        .split("")
        .reverse()
        .reduce((acc, curr) => acc + curr, 0)
    )
  );

  return reversedArr.filter((v) => {
    let count = 0;
    for (let i = 1; i <= v; i++) {
      if (v % i === 0) count += 1;
    }
    return count === 2;
  });
};

fn(9, [32, 55, 62, 20, 250, 370, 200, 30, 100]);
