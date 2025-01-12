const solution = (arr) => {
    let answer = "NO";
    let total = arr.reduce((a, b) => a + b, 0);
    let flag = 0;
    const DFS = (L, sum) => {
        if (flag) return;
        if (L === arr.length) {
            if (sum === (total - sum)) {
                answer = "YES";
                flag = 1;
            }
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
    DFS(0, 0);
    return answer;
}

console.log(solution([1, 3, 5, 6, 7, 10]));