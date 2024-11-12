const solution = (arr) => {
  const result = [];
  arr.forEach((item, index) => {
    if (index === 0 || arr[index - 1] < item) {
      result.push(item);
    }
  });

  return result;
};

console.log(solution([7, 3, 9, 5, 6, 12]));
