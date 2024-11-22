const solution = (str) => {
  const convertedStr = str.toLowerCase().replace(/[^a-zA]/g, "");
  const reversedStr = convertedStr.split("").reverse().join("");
  if (reversedStr === convertedStr) return "YES";

  return "NO";
};

console.log(solution("found7, time: study; Yduts; emit, 7Dnuof"));
