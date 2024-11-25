const fn = (word) => {
  const alphabetCount = [];
  const splitedWord = word.split("");
  splitedWord.forEach((v, idx) => {
    if (splitedWord[idx - 1] === v) {
      alphabetCount[alphabetCount.length - 1] = {
        [v]: alphabetCount[alphabetCount.length - 1][v] + 1,
      };
    } else alphabetCount.push({ [v]: 1 });
  });

  return alphabetCount
    .reduce((acc, curr) => acc + Object.entries(curr)[0].join(""), "")
    .split("1")
    .join("");
};

fn("KKHSSSSSSSE");
