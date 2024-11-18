const solution = (a, b) => {
  const answer = [];

  for (let i = 0; i < a.length; i++) {
    const aAnswer = a[i];
    const bAnswer = b[i];

    if (aAnswer === bAnswer) {
      answer.push("D");
    } else if (
      (aAnswer === 1 && bAnswer === 3) ||
      (aAnswer === 2 && bAnswer === 1) ||
      (aAnswer === 3 && bAnswer === 2)
    ) {
      answer.push("A");
    } else {
      answer.push("B");
    }
  }

  return answer;
};

console.log(solution([2, 3, 3, 1, 3], [1, 1, 2, 2, 3]));
