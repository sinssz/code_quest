const solution = (필수과목, 수강신청과목) => {
  const 필수과목배열 = 필수과목.split("");
  const 수강신청과목배열 = 수강신청과목.split("");

  for (let i = 0; i < 수강신청과목배열.length; i++) {
    if (필수과목배열.includes(수강신청과목배열[i]) !== -1) {
      if (필수과목배열[0] === 수강신청과목배열[i]) {
        필수과목배열.shift();
      }
    }
  }

  return 필수과목배열.length === 0 ? "YES" : "NO";
};

console.log(solution("CBA", "CBDAGE"));
console.log(solution("CBA", "BDDAGE"));
