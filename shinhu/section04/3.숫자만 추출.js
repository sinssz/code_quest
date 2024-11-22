const solution = (str) => {
  const convertedStr = str.replace(/[^0-9]/g, "");
  return Number(convertedStr);
};

console.log(solution("g0en2T0s8eSoft"));
