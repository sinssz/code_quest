const solution = (arr) => {
  const result = [];
  for (let i = 0; i < arr.length; i++) {
    const num = Number(arr[i].toString().split("").reverse().join(""));
    if ((num % 2 === 0 && num > 2) || num === 1) {
      continue;
    }

    if (isPrime(num)) {
      result.push(num);
    }
  }

  return result;
};

const isPrime = (num) => {
  if (num === 1) return false;
  for (let i = 2; i <= num / 2; i++) {
    if (num % i === 0) return false;
  }
  return true;
};

console.log(solution([32, 55, 62, 20, 250, 370, 200, 30, 100]));
