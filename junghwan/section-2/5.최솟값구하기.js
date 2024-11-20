const solution = (input) => {
  let answer = Number.MAX_SAFE_INTEGER;

  for (const num of input) {
    if (answer > num) {
      answer = num;
    }
  }
  return answer;
};

console.log(solution([5, 7, 1, 3, 2, 9, 11]));
console.log(Math.min(...[5, 7, 1, 3, 2, 9, 11]));
