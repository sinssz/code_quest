const solution = (arr, k) => {
  let max = 0;
  for (let i = 0; i <= arr.length - k; i++) {
    let sum = 0;
    for (let j = 0; j < k; j++) {
      sum += arr[i + j];
    }
    max = Math.max(max, sum);
  }

  return max;
};
// console.log(solution([12, 15, 11, 20, 25, 10, 20, 19, 13, 15], 3));

const solution2 = (arr, k) => {
  let result = 0;
  let sum = 0;
  for (let i = 0; i < k; i++) {
    sum += arr[i];
  }
  result = sum;

  for (let i = k; i < arr.length; i++) {
    sum += arr[i] - arr[i - k];
    result = Math.max(result, sum);
  }
};

console.log(solution2([12, 15, 11, 20, 25, 10, 20, 19, 13, 15], 3));
