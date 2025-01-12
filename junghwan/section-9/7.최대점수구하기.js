const solution = (m, arr) => {
    let answer = 0;
    const DFS = (L, sum, time) => {
        if (time > m) return;
        if (L === arr.length) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L][0], time + arr[L][1]);
            DFS(L + 1, sum, time);
        }
    }
    DFS(0, 0, 0);
    return answer;
}

console.log(solution(20, [[10, 5], [25, 12], [15, 8], [6, 3], [7, 4]]));