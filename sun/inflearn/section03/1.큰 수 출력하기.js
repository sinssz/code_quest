function solution(arr) {
let answer = [];

for (let i = 0; i < arr.length; i++) {
if (i === 0) {
answer.push(arr[i]);
continue;
}

if (arr[i] > arr[i-1]) {
answer.push(arr[i]);
}
}

return answer;
}

let arr = [7, 3, 9, 5, 6, 12];
console.log(solution(arr));