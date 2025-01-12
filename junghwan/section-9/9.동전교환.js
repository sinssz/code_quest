const solution = (n, arr) => {
    let answer = Number.MAX_SAFE_INTEGER;
    
    const DFS = (L, sum) => {
        if (sum > n) return;        // 합이 목표값을 초과하면 종료
        if (L >= answer) return;    // 현재 동전 개수가 이미 찾은 최소 개수보다 크면 종료
        if (sum === n) {           // 합이 목표값과 같으면
            answer = Math.min(answer, L);
            return;
        }
        
        for (let i = 0; i < arr.length; i++) {
            DFS(L + 1, sum + arr[i]);
        }
    }
    
    DFS(0, 0);
    return answer;
}

console.log(solution(15, [1, 2, 5]));  // 3 (5+5+5 = 15)