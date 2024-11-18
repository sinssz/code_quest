const fn = (n, nArr) => {
  const splitN = nArr.split(" ").map(Number);

  return splitN
    .filter((v, idx) => {
      if (idx === 0) {
        return v > n;
      }
      return v > splitN[idx - 1];
    })
    .join(" ");
};

fn(6, "7 3 9 5 6 12");
