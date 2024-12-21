const fn = (numArr, selectNum) => {
  for (let i = 0; i < numArr.length - 1; i++) {
    const pickNum = numArr[i];

    let leastNumIdx = i + 1;
    for (let j = i + 1; j < numArr.length; j++) {
      if (numArr[j] < numArr[leastNumIdx]) {
        leastNumIdx = j;
      }
    }

    if (numArr[i] > numArr[leastNumIdx]) {
      numArr[i] = numArr[leastNumIdx];
      numArr[leastNumIdx] = pickNum;
    }
  }

  let dichotomyIdx = Math.floor(numArr.length - 1 / 2);
  let startIdx = 0;
  let endIdx = numArr.length - 1;

  while (numArr[dichotomyIdx] !== selectNum) {
    if (numArr[dichotomyIdx] < selectNum) {
      startIdx = dichotomyIdx;
    } else {
      endIdx = dichotomyIdx;
    }

    dichotomyIdx = Math.floor((startIdx + endIdx) / 2);
  }

  return dichotomyIdx + 1;
};

fn([23, 87, 65, 12, 57, 32, 99, 81], 87);
