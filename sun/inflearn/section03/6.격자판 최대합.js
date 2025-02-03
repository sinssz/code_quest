const solution = (n, arr) => {
    let result = Number.MIN_SAFE_INTEGER;
    let sum1 = 0;
    let sum2 = 0;

    for (let i = 0; i < n; i++) {
        sum1 = 0;
        sum2 = 0;

        for (let j = 0; j < n; j++) {
            sum1 += arr[i][j];
            sum2 += arr[j][i];
        }

        result = Math.max(result, sum1, sum2);
    }

    sum1 = 0;
    sum2 = 0;

    for (let i = 0; i < n; i++) {
        sum1 += arr[i][i];
        sum2 += arr[i][n - 1 - i];
    }

    result = Math.max(result, sum1, sum2);

    return result;
};

let arr=[[10, 13, 10, 12, 15],
    [12, 39, 30, 23, 11],
    [11, 25, 50, 53, 15],
    [19, 27, 29, 37, 27],
    [19, 13, 30, 13, 19]];
console.log(solution(5, arr));