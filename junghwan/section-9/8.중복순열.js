const solution = (n, m) => {
    let answer = [];
    const DFS = (L, arr) => {
        if (L === m) {
            answer.push(arr);
        } else {
            for (let i = 1; i <= n; i++) {
                DFS(L + 1, [...arr, i]);
            }
        }
    }
    DFS(0, []);
    return answer;
}

console.log(solution(3, 2));