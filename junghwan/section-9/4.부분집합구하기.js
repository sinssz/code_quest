const solution = (n) => {
    const ch = Array(n + 1).fill(0);
    const DFS = (L) => {
        if (L === n + 1) {
            let tmp = "";
            for (let i = 1; i <= n; i++) {
                if (ch[i] === 1) tmp += i + " ";
            }
            if (tmp.length > 0) console.log(tmp.trim());
        } else {
            ch[L] = 1; 
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    };
    
    DFS(1);
};

solution(3);
