const solution = (arr) => {
  let result = 0;
  let cnt = 0;
  for (const answer of arr) {
    if (answer === 1) {
      cnt += 1;
      result += cnt;
    } else {
      cnt = 0;
    }
  }
  return result;
};
console.log(solution([1, 0, 1, 1, 1, 0, 0, 1, 1, 0]));
