const solution = (arr, target) => {
  arr.sort((a, b) => a - b);

  let lt = 0;
  let rt = arr.length - 1;

  while (lt <= rt) {
    let mid = parseInt((lt + rt) / 2);

    if (arr[mid] === target) return mid + 1;
    else if (arr[mid] > target) rt = mid - 1;
    else lt = mid + 1;
  }
};

console.log(solution([23, 87, 65, 12, 57, 32, 99, 81], 32));
