const solution = (arr1, arr2) => {
  const result = [...arr1, ...arr2].sort((a, b) => a - b);
  return result;
};

// console.log(solution([1, 3, 5], [2, 3, 6, 7, 9]));

const solution2 = (arr1, arr2) => {
  const result = [];
  let p1 = 0;
  let p2 = 0;

  while (arr1.length > p1 || arr2.length > p2) {
    if (arr1[p1] <= arr2[p2]) {
      result.push(arr1[p1]);
      p1++;
    } else {
      result.push(arr2[p2]);
      p2++;
    }
  }

  return result;
};

console.log(solution2([1, 3, 5], [2, 3, 6, 7, 9]));
