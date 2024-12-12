const solution = (n) => {
  const stack = [];
  let result = 0;

  const arr = n.split("");

  for (let i = 0; i < arr.length; i++) {
    if (i === 0 || !stack[stack.length - 1]) {
      stack.push(arr[i]);
      continue;
    }

    const prev = arr[i - 1];
    const current = arr[i];

    const isLaser = prev !== current;

    if (stack[stack.length - 1] !== arr[i]) {
      stack.pop();
      if (isLaser) {
        result += stack.length;
      } else {
        // 마지막 쇠 막대기 조각 + 1
        result++;
      }
    } else {
      stack.push(arr[i]);
    }
  }

  return result;
};

console.log(solution("()(((()())(())()))(())"));
