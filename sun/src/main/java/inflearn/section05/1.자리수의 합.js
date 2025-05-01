const solution = (n, arr) => {
  let result;
  let max = Number.MIN_SAFE_INTEGER;

  for (let index = 0; index < n; index++) {
    const sum = String(arr[index])
      .split("")
      .map(Number)
      .reduce((a, b) => a + b, 0);

    if (sum > max) {
      max = sum;
      result = arr[index];
    } else if (sum === max && arr[index] > result) {
      result = arr[index];
    }
  }

  return result;
};

let arr = [128, 460, 603, 40, 521, 137, 123];
console.log(solution(7, arr));
