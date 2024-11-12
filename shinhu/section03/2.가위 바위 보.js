const solution = (arr1, arr2) => {
  const answerObj = [
    ["D", "B", "A"],
    ["A", "D", "B"],
    ["B", "A", "D"],
  ];
  for (let i = 0; i < arr1.length; i++) {
    console.log(answerObj[arr1[i] - 1][arr2[i] - 1]);
  }
};

solution([2, 3, 3, 1, 3], [1, 1, 2, 2, 3]);
