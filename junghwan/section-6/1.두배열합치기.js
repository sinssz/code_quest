const solution = (arr1, arr2) => {
  const result = [];
  let p1 = 0;
  let p2 = 0;

  while (p1 < arr1.length && p2 < arr2.length) {
    if (arr1[p1] <= arr2[p2]) {
      result.push(arr1[p1++]);
    } else {
      result.push(arr2[p2++]);
    }
  }

  while (p1 < arr1.length) {
    result.push(arr1[p1++]);
  }

  while (p2 < arr2.length) {
    result.push(arr2[p2++]);
  }

  return result;
};

console.log(solution([1, 3, 5], [2, 3, 6, 7, 9]));
