const solution = (budget, products) => {
    let result = 0;
    const n = products.length;
    const sortedProducts = products.sort((a, b) => (a[0] + a[1]) - (b[0] + b[1]));

    for (let i = 0; i < n; i++) {
        let money = budget - (sortedProducts[i][0] / 2 + sortedProducts[i][1]);
        let cnt = 1;
        for (let j = 0; j < n; j++) {
            if (j !== i && (sortedProducts[j][0] + sortedProducts[j][1]) > money) break;
            if (j !== i && (sortedProducts[j][0] + sortedProducts[j][1]) <= money) {
                money -= (sortedProducts[j][0] + sortedProducts[j][1]);
                cnt++;
            }
        }
        result = Math.max(result, cnt);
    }
    return result;
};

console.log(
    solution(28, [
        [6, 6],
        [2, 2],
        [4, 3],
        [4, 5],
        [10, 3],
    ])
);