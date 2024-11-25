const fn = (word) => {
  const wordToLowerCase = word.toLowerCase();

  const length = Math.floor(wordToLowerCase.length / 2);

  for (let i = 0; i < length; i++) {
    if (wordToLowerCase[i] !== wordToLowerCase[wordToLowerCase.length - 1 - i])
      return "NO";
  }

  return "YES";
};
