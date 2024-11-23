const solution = (str1, str2) => {
  const length = str1.length;
  let answer = Array(length).fill(1000);

  for (let i = 0; i < length; i++) {
    if (str1[i] === str2) {
      answer[i] = 0;
    } else if (i > 0) {
      answer[i] = Math.min(answer[i], answer[i - 1] + 1);
    }
  }

  for (let i = length - 1; i >= 0; i--) {
    if (str1[i] === str2) {
      answer[i] = 0;
    } else if (i < length - 1) {
      answer[i] = Math.min(answer[i], answer[i + 1] + 1);
    }
  }

  return answer;
};

console.log(solution("teachermode", "e"));
// [1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0]
