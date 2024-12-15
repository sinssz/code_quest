const fn = (sign) => {
  const signArr = sign.split("");
  const stack = [];

  let ans = "YES";

  while (!!signArr.length) {
    if (signArr[0] === "(") stack.push(signArr.shift());
    else {
      if (!stack.length) {
        ans = "NO";
        break;
      }
      if (stack.pop() !== signArr.shift()) ans = "YES";
      else {
        ans = "NO";
        break;
      }
    }
  }

  if (stack.length) ans = "NO";

  return ans;
};

fn();
