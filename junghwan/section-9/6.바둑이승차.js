const solution = (c, arr) => {
    let answer = 0;
    const DFS = (L, sum) => {
        if (sum > c) return;
        if (L === arr.length) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]); // 현재 바둑이를 태우는 경우
            DFS(L + 1, sum); // 현재 바둑이를 태우지 않는 경우
        }
    }
    DFS(0, 0);
    return answer;
}

console.log(solution(259, [81, 58, 42, 33, 61]));