const isPrime = (num) => {
  if (num === 1) return false;
  for (let i = 2; i <= parseInt(Math.sqrt(num)); i++) {
    if (num % i === 0) return false;
  }
  return true;
};

const solution = (arr) => {
  let answer = [];

  for (const num of arr) {
    const reversedStr = num.toString().split("").reverse().join("");
    const parsed = Number(reversedStr);

    if (isPrime(parsed)) answer.push(parsed);
  }

  return answer;
};

console.log(solution([32, 55, 62, 20, 250, 370, 200, 30, 100]));
