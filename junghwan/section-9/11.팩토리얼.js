const solution = (n) => {
  if (n === 0) return 1;
  return n * solution(n - 1);
};

console.log(solution(5));
