const solution = (str) => {
  let result = "";
  for (let i = 0; i < str.length; i++) {
    let cnt = 1;
    for (let j = i + 1; j < str.length; j++) {
      if (str[i] === str[j]) {
        cnt++;
        i++;
      } else {
        break;
      }
    }
    result += str[i];
    if (cnt > 1) {
      result += cnt;
    }
  }

  return result;
};

const solution2 = (str) => {
  let cnt = 1;
  let result = "";
  for (let i = 0; i < str.length; i++) {
    if (str[i] === str[i + 1]) {
      cnt++;
    } else {
      result += str[i];
      if (cnt > 1) {
        result += cnt;
      }
      cnt = 1;
    }
  }
  return result;
};

console.log(solution("KKHSSSSSSSE"));
console.log(solution2("KKHSSSSSSSE"));
