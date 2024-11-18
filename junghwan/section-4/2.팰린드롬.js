const solution = (str) => {
  const replaced = str.toLowerCase().replace(/[^a-zA-Z]/g, "");
  return replaced === replaced.split("").reverse().join("") ? "YES" : "NO";
};

console.log(solution("found7, time: study; Yduts; emit, 7Dnuof"));
