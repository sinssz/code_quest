const fn = (set, A, B) => {
  const RSP = (a, b) => {
    if (a === b) return "D";

    const customA = a === "2" ? a : (a + 1) % 3;
    if (customA === b) return "B";
    return "A";
  };

  const convertedA = A.split(" ").map(Number);
  const convertedB = B.split(" ").map(Number);

  const result = [];
  for (let i = 0; i < convertedA.length; i++) {
    result.push(RSP(convertedA[i], convertedB[i]));
  }

  return result.join(" ");
};

fn(5, "2 3 3 1 3", "1 1 2 2 3");
