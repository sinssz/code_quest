const solution = (str) => {
  const candidates = {
    A: 0,
    B: 0,
    C: 0,
    D: 0,
    E: 0,
  };

  for (let i = 0; i < str.length; i++) {
    candidates[str[i]]++;
  }

  return Object.entries(candidates).reduce((acc, [key, value]) => {
    return candidates[acc] > value ? acc : key;
  }, "A");
};

console.log(solution("BACBACCACCBDEDE"));
