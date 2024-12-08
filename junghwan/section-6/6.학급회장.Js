const solution = (votes) => {
  const candidates = new Map();
  let min = Number.MIN_SAFE_INTEGER;
  let answer = "";

  votes.forEach((vote) => {
    candidates.set(vote, (candidates.get(vote) || 0) + 1);
  });

  for (const [key, value] of candidates) {
    if (value > min) {
      min = value;
      answer = key;
    }
  }

  return answer;
};

console.log(
  solution([
    "B",
    "A",
    "C",
    "B",
    "A",
    "C",
    "C",
    "A",
    "C",
    "C",
    "B",
    "D",
    "E",
    "D",
    "E",
  ])
);
