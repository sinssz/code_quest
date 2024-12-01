const solution = (arr) => {
  let answer = 0;
  const m = arr.length; // 테스트 횟수
  const n = arr[0].length; // 학생 수

  // 모든 학생 쌍의 경우의 수를 검사 (mentor: i, mentee: j)
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
      if (i === j) continue; // 같은 학생은 건너뛰기

      let count = 0;
      // 각 테스트별로 확인
      for (let k = 0; k < m; k++) {
        let mentor_pos = 0;
        let mentee_pos = 0;
        // 해당 테스트에서 멘토와 멘티의 등수 위치 찾기
        for (let s = 0; s < n; s++) {
          if (arr[k][s] === i) mentor_pos = s;
          if (arr[k][s] === j) mentee_pos = s;
        }
        // 멘토의 등수가 멘티보다 앞서면 카운트
        if (mentor_pos < mentee_pos) count++;
      }

      if (count === m) answer++;
    }
  }

  return answer;
};

console.log(
  solution([
    [3, 4, 1, 2],
    [4, 3, 2, 1],
    [3, 1, 4, 2],
  ])
);
