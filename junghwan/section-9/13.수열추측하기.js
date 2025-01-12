const solution = (n, f) => {
  let answer;
  let flag = 0;
  // 조합 값을 저장할 2차원 배열
  let dy = Array.from(Array(11), () => Array(11).fill(0));
  // 숫자 사용 여부를 체크할 배열
  let ch = Array.from({ length: n + 1 }, () => 0);
  let p = []; // 순열을 저장할 배열
  let b = []; // 이항계수를 저장할 배열

  // 조합 구하는 함수 (메모이제이션 적용)
  function combi(n, r) {
    if (dy[n][r] > 0) return dy[n][r];
    if (n === r || r === 0) return 1;
    else return (dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r));
  }

  // 이항계수 구하기
  for (let i = 0; i < n; i++) {
    b.push(combi(n - 1, i));
  }

  function DFS(L, sum) {
    if (flag) return;
    if (L === n && sum === f) {
      answer = p.slice();
      flag = 1;
    } else {
      for (let i = 1; i <= n; i++) {
        if (ch[i] === 0) {
          ch[i] = 1;
          p.push(i);
          DFS(L + 1, sum + b[L] * i);
          ch[i] = 0;
          p.pop();
        }
      }
    }
  }
  
  DFS(0, 0);
  return answer;
};

console.log(solution(4, 16));