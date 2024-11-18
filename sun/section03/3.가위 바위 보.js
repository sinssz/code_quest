function solution(n, a, b) {
    let result = [];
    for (let i = 0; i < n; i++) {
        // 비겼을 때
        if (a[i] === b[i]) {
            result.push("D");
            continue;
        }
        // a = 가위
        if (a[i] === 1) {
            if (b[i] === 2) {
                result.push("B")
            }

            if (b[i] === 3) {
                result.push("A")
            }
        }
        // a = 바위
        if (a[i] === 2) {
            if (b[i] === 1) {
                result.push("A")
            }

            if (b[i] === 3) {
                result.push("B")
            }
        }

        // a = 보
        if (a[i] === 3) {
            if (b[i] === 1) {
                result.push("B")
            }

            if (b[i] === 2) {
                result.push("A")
            }
        }
    }

    return result.join("\n");
}

let n = 5;
let a = [2, 3, 3, 1, 3];
let b = [1, 1, 2, 2, 3];
console.log(solution(n, a, b));