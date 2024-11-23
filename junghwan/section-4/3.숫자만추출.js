const solution = (str) => {
  const filtered = str.replace(/[^0-9]/g, "");
  const sumOfFilteredNum = filtered
    .split("")
    .reduce((acc, cur) => acc + Number(cur), 0);
  return sumOfFilteredNum;
};

console.log(solution("g0en2T0s8eSoft"));
