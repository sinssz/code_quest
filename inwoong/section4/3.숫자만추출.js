const fn = (word) => {
  const digit = "1234567890";
  const filterdDigitWord = word
    .split("")
    .filter((v) => digit.includes(v))
    .join("");

  return Number(filterdDigitWord);
};

fn("g0en2T0s8eSoft");
