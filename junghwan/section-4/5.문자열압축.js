const solution = (str) => {
  let answer = [];
  let cnt = 1;

  for (let i = 0; i < str.length; i++) {
    const char = str[i];
    const nextChar = str?.[i + 1];
    if (char !== nextChar) {
      answer.push(char);
      if (cnt !== 1) {
        answer.push(cnt);
      }
      cnt = 1;
    } else {
      cnt += 1;
    }
  }
  return answer.join("");
};

console.log(solution("KKHSSSSSSSE"));
