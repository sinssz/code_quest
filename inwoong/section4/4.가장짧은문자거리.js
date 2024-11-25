const fn = (s, t) => {
  const sArr = s.split("");
  const indexTArr = sArr.reduce((acc, curr, idx) => {
    if (curr === t) return [...acc, idx];
    return acc;
  }, []);

  let i = 0;
  return sArr.map((v, idx) => {
    if (idx === indexTArr[i]) {
      return 0;
    }

    if (Math.abs(idx - indexTArr[i]) > Math.abs(idx - indexTArr[i + 1])) {
      const diff = Math.abs(idx - indexTArr[i + 1]);

      i += 1;
      return diff;
    }
    return Math.abs(idx - indexTArr[i]);
  });
};

fn("teachermode", "e");
