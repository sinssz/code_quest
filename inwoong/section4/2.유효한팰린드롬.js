const fn = (word) => {
  const alphabet = "abcdefghijklmnopqrstuvwxyz";
  const wordToAlphabetLowerCase = word
    .toLowerCase()
    .split("")
    .filter((v) => alphabet.includes(v));

  const length = Math.floor(wordToAlphabetLowerCase.length / 2);

  for (let i = 0; i < length; i++) {
    console.log(
      wordToAlphabetLowerCase[i],
      wordToAlphabetLowerCase[wordToAlphabetLowerCase.length - 1 - i]
    );
    if (
      wordToAlphabetLowerCase[i] !==
      wordToAlphabetLowerCase[wordToAlphabetLowerCase.length - 1 - i]
    )
      return "NO";
  }

  return "YES";
};

fn("found7, time: study; Yduts; emit, 7Dnuof");
