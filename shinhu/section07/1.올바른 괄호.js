const solution = (parentheses) => {
  const stack = [];

  for (let i = 0; i < parentheses.length; i++) {
    if (!stack[stack.length - 1]) {
      stack.push(parentheses[i]);
      continue;
    } else {
      if (parentheses[i] !== stack[stack.length - 1]) {
        stack.pop();
      } else {
        stack.push(parentheses[i]);
      }
    }
  }

  return stack.length === 0 ? "YES" : "NO";
};

console.log(solution("(()(()))(()"));
console.log(solution("(())()"));
console.log(solution("(()()))"));
