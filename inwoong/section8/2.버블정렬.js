const fn = (arr) => {
  let endIdx = arr.length;
  for (let i = 0; i < arr.length - 1; i++) {
    let pickNumIdx = 0;
    for (let j = pickNumIdx + 1; j < endIdx; j++) {
      if (arr[pickNumIdx] > arr[j]) {
        const changedNum = arr[j];
        arr[j] = arr[pickNumIdx];
        arr[pickNumIdx] = changedNum;
      }
      pickNumIdx = j;
    }
    endIdx -= 1;
  }

  return arr;
};

console.log(fn([13, 5, 23, 15, 1, 2, 4, 11, 5, 2, 100, 101, 88]));
