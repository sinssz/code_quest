let answer = "";
const solution = (n) => {
  if (n === 0) return;
  solution(parseInt(n / 2, 10));
  answer = answer + String(n % 2);
  return answer;
};

console.log(solution(11));
