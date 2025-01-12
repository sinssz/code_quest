const solution = (n, m) => {
    let answer = [];
    let ch = Array(n+1).fill(0);
    
    const DFS = (L, arr) => {
        if (L === m) {
            answer.push([...arr]);
        } else {
            for (let i = 1; i <= n; i++) {
                if (ch[i] === 0) {
                    ch[i] = 1;
                    DFS(L + 1, [...arr, i]);
                    ch[i] = 0;
                }
            }
        }
    }
    
    DFS(0, []);
    return answer;
}

console.log(solution(3, 2));