const solution = (n, k) => {
  let queue = Array(n)
    .fill(0)
    .map((_, i) => i + 1);

  let result = null;

  let index = 1;
  while (queue.length > 0) {
    if (index === k) {
      result = queue.shift();
      index = 1;
    } else {
      const temp = queue.shift();
      queue.push(temp);
      index++;
    }
  }

  return result;
};

console.log(solution(8, 3));
