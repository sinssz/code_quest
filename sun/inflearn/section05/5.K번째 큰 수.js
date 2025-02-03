const solution = (n, K, card) => {
    let result;
    let tmp = new Set();

    for (let i = 0; i <= n - 2; i++) {
        for (let j = i + 1; j <= n - 1; j++) {
            for (let k = j + 1; k < n; k++) {
                tmp.add(card[i] + card[j] + card[k]);
            }
        }
    }

    let a = Array.from(tmp)
        .sort((a, b) => b - a);

    result = a[K - 1];

    return result;
}

let arr = [13, 15, 34, 23, 45, 65, 33, 11, 26, 42];
console.log(solution(10, 3, arr));