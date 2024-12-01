function solution(n, k, card) {
  // 3개의 숫자 조합으로 만들 수 있는 모든 합을 저장할 Set
  const sums = new Set();

  // 3중 반복문으로 모든 조합의 합을 구함
  for (let i = 0; i < n; i++) {
    for (let j = i + 1; j < n; j++) {
      for (let m = j + 1; m < n; m++) {
        sums.add(card[i] + card[j] + card[m]);
      }
    }
  }

  // Set을 배열로 변환하고 내림차순 정렬
  const uniqueSorted = [...sums].sort((a, b) => b - a);

  // k번째 수가 존재하면 반환, 없으면 -1 반환
  return k <= uniqueSorted.length ? uniqueSorted[k - 1] : -1;
}

console.log(solution(10, 3, [13, 15, 34, 23, 45, 65, 33, 11, 26, 42]));
