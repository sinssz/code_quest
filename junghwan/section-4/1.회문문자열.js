const solution = (str) =>
  str.toLowerCase() === str.toLowerCase().split(" ").reverse().join(" ")
    ? "YES"
    : "NO";

