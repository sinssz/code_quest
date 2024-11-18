const biggestNumber = (arr) => {
  let max = 0;
  for (const num of arr) {
    if (num > max) {
      max = num;
    }
  }

  return max;
};

console.log(biggestNumber([6, 7, 3, 9, 5, 6, 12]));
console.log(Math.max(...[6, 7, 3, 9, 5, 6, 12]));
