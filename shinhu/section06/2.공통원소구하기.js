const solution = (arr1, arr2) => {
  const result = [];
  const parents = arr1.length > arr2.length ? arr1 : arr2;
  const children = arr1.length > arr2.length ? arr2 : arr1;

  for (let i = 0; i < children.length; i++) {
    if (parents.includes(children[i])) {
      result.push(children[i]);
    }
  }
  return result.sort((a, b) => a - b);
};

// console.log(solution([1, 3, 9, 5, 2], [3, 2, 5, 7, 8]));

const solution2 = (arr1, arr2) => {
  const result = [];
  let p1 = 0;
  let p2 = 0;
  while (
    arr1.sort((a, b) => a - b).length > p1 &&
    arr2.sort((a, b) => a - b).length > p2
  ) {
    if (arr1[p1] === arr2[p2]) {
      result.push(arr1[p1]);
      p1++;
      p2++;
      continue;
    } else if (arr1[p1] < arr2[p2]) {
      p1++;
    } else {
      p2++;
    }
  }

  return result;
};

console.log(solution2([1, 3, 9, 5, 2], [3, 2, 5, 7, 8]));
