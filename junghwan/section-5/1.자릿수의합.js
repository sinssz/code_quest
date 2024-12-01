const solution = (arr) => {
  let max = Number.MIN_SAFE_INTEGER;

  for (const each of arr) {
    const sum = each
      .toString()
      .split("")
      .reduce((acc, cur) => {
        return acc + +cur;
      }, 0);
    if (max <= sum) {
      max = each;
    }
  }
  return max;
};

console.log(solution([128, 460, 603, 40, 521, 137, 123]));
