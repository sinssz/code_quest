const solution = (arr) => {
    let n = arr.length;
    // 0으로 새로운 배열 초기화
    let grid = Array.from({length: n + 2}, () => Array(n + 2).fill(0));
    // 기존 값 복사
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            grid[i + 1][j + 1] = arr[i][j];
        }
    }

    let peaks = 0;

    for (let i = 1; i < grid.length - 1; i++) {
        for (let j = 1; j < grid.length - 1; j++) {
            const center = grid[i][j];

            // up
            if (grid[i - 1][j] >= center) {
                continue;
            }
            // down
            if (grid[i + 1][j] >= center) {
                continue;
            }
            // left
            if (grid[i][j - 1] >= center) {
                continue;
            }
            // right
            if (grid[i][j + 1] >= center) {
                continue;
            }

            peaks++;
        }
    }

    return peaks;
}

let arr = [[5, 3, 7, 2, 3],
    [3, 7, 1, 6, 1],
    [7, 2, 5, 3, 4],
    [4, 3, 6, 4, 1],
    [8, 7, 3, 5, 2]];
console.log(solution(arr));