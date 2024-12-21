const fn = (attedPlan) => {
  let maxCount = 1;

  for (let i = 0; i < attedPlan.length - 1; i++) {
    const pickNum = attedPlan[i];

    let leastNumIdx = i + 1;
    for (let j = i + 1; j < attedPlan.length; j++) {
      if (attedPlan[leastNumIdx][0] > attedPlan[j][0]) {
        leastNumIdx = j;
      }
      if (attedPlan[leastNumIdx][0] === attedPlan[j][0]) {
        if (attedPlan[leastNumIdx][1] > attedPlan[j][1]) {
          leastNumIdx = j;
        }
      }
    }

    if (pickNum[0] > attedPlan[leastNumIdx][0]) {
      attedPlan[i] = attedPlan[leastNumIdx];
      attedPlan[leastNumIdx] = pickNum;
    }
    if (pickNum[0] === attedPlan[leastNumIdx][0]) {
      if (pickNum[1] > attedPlan[leastNumIdx][1]) {
        attedPlan[i] = attedPlan[leastNumIdx];
        attedPlan[leastNumIdx] = pickNum;
      }
    }
  }

  let scopeArr = [];
  for (let i = 0; i < attedPlan.length - 1; i++) {
    let tempMaxCount = 1;
    for (let j = i + 1; j < attedPlan.length; j++) {
      if (!scopeArr.length || scopeArr[1] <= attedPlan[j][0]) {
        scopeArr = [
          Math.max(attedPlan[j][0], attedPlan[i][0]),
          Math.min(attedPlan[j][1], attedPlan[i][1]),
        ];
        maxCount = Math.max(tempMaxCount, maxCount);
        tempMaxCount = 1;
      } else {
        scopeArr = [
          Math.max(attedPlan[j][0], scopeArr[0]),
          Math.min(attedPlan[j][1], scopeArr[1]),
        ];
      }

      if (scopeArr[1] - scopeArr[0] > 0) tempMaxCount += 1;
    }
    maxCount = Math.max(tempMaxCount, maxCount);
  }

  return maxCount;
};

fn([
  [6, 7],
  [2, 3],
  [9, 10],
  [3, 4],
  [1, 2],
  [7, 8],
  [5, 6],
  [8, 9],
  [0, 1],
  [4, 5],
]);
