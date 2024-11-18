const solution = (input) => {
  let oddSum = 0;
  let minOdd = Number.MAX_SAFE_INTEGER;

  for (const num of input) {
    if (num % 2 === 1) {
      oddSum += num;
      minOdd = Math.min(minOdd, num);
    }
  }

  return minOdd === Number.MAX_SAFE_INTEGER ? [0, 0] : [oddSum, minOdd];
};

console.log(solution([12, 77, 38, 41, 53, 92, 85]));
