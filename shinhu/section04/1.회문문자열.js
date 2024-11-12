const solution = (str) => {
  if (str.length % 2) return "NO";
  const convertedStr = str.toLowerCase();
  if (convertedStr.split("").reverse().join("") === convertedStr) return "YES";
  return "NO";
};

console.log(solution("goo"));
