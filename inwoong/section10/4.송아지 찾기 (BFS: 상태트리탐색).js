const findCalf = (s, e) => {
  const visited = Array(10001).fill(false);
  const queue = [[s, 0]];
  const directions = [1, -1, 5];

  while (queue.length) {
    const [current, jumps] = queue.shift();
    if (current === e) {
      console.log(jumps);
      return;
    }
    for (let dir of directions) {
      const next = current + dir;
      if (next >= 1 && next <= 10000 && !visited[next]) {
        visited[next] = true;
        queue.push([next, jumps + 1]);
      }
    }
  }
};

findCalf(5, 14);
findCalf(8, 3);
