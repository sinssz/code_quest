function solution(times) {
  let answer = 0;
  let timeLine = [];

  for (let x of times) {
    timeLine.push([x[0], 1]);
    timeLine.push([x[1], -1]);
  }

  timeLine.sort((a, b) => {
    if (a[0] === b[0]) return b[1] - a[1];
    return a[0] - b[0];
  });

  let cnt = 0;

  for (let x of timeLine) {
    cnt += x[1];
    answer = Math.max(answer, cnt);
  }

  return answer;
}

console.log(solution([14, 18], [12, 15], [15, 20], [20, 30], [5, 14]));
