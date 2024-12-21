const fn = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    const pickNum = arr[i];
    let leastNumIdx = i + 1;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[leastNumIdx] > arr[j]) leastNumIdx = j;
    }
    if (arr[i] > arr[leastNumIdx]) {
      arr[i] = arr[leastNumIdx];
      arr[leastNumIdx] = pickNum;
    }
  }

  return arr;
};

fn([13, 5, 11, 7, 23, 15, 1, 8, 2, 4, 3, 100]);
