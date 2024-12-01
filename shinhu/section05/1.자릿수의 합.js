const solution = (arr) => {
  let result = 0;
  let resultSum = 0;

  for (let i = 0; i < arr.length; i++) {
    const sum = arr[i]
      .toString()
      .split("")
      .reduce((acc, cur) => {
        return acc + Number(cur);
      }, 0);

    if (sum > resultSum) {
      result = arr[i];
      resultSum = sum;
    } else if (sum === resultSum) {
      result = arr[i] > result ? arr[i] : result;
    }
  }

  return result;
};

console.log(solution([123, 460, 603, 40, 521, 235, 1234]));
