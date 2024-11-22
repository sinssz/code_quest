const solution = (str, target) => {
  const result = [];
  for (let i = 0; i < str.length; i++) {
    let targetIndex = null;
    for (let j = 0; j < str.length; j++) {
      const targetStr = str[j];
      const distance = Math.abs(j - i);
      if (targetStr === target) {
        targetIndex =
          targetIndex !== null ? Math.min(targetIndex, distance) : distance;
      }
    }
    result.push(targetIndex);
  }
  return result;
};

console.log(solution("teachermode", "e"));
