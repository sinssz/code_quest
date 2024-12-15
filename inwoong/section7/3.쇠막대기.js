const fn = (pipe) => {
  const stack = [];
  let ans = 0;
  for (let i = 0; i < pipe.length; i++) {
    if (pipe[i] === "(") {
      stack.push(stack.length + 1);
    } else {
      if (pipe[i - 1] === "(") {
        const pipeNum = stack.pop();
        ans += pipeNum - 1;
      } else {
        stack.pop();
        ans += 1;
      }
    }
  }
};

fn("(((()(()()))(())()))(()())");
