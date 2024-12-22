const solution = (arr) => {
  const sortedArr = [...arr].sort((a, b) => a - b);
  const answer = arr
    .map((height, index) => (height !== sortedArr[index] ? index + 1 : 0))
    .filter((num) => num !== 0);
  return answer;
};

console.log(solution([120, 125, 152, 130, 135, 135, 143, 127, 160]));
console.log(solution([120, 130, 150, 150, 130, 150]));
