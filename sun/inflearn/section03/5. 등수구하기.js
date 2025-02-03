const solution = (n, arr) => {
    const toSorted = arr.toSorted((a, b) => b - a);

    let result = [];
    for (let i = 0; i < arr.length; i++) {
        const indexOf = toSorted.indexOf(arr[i]);
        result.push(indexOf + 1);
    }

    return result;
}

console.log(solution(5, [87, 89, 92, 100, 76]));
console.log(solution(5, [92, 92, 92, 87, 76]));
console.log(solution(5, [92, 87, 87, 87, 76]));