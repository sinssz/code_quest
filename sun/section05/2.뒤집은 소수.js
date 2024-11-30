const solution = (arr) => {
    // 숫자를 뒤집는 함수
    function reverseNumber(number) {
        const reversed = String(number)
            .split('')
            .reverse()
            .join('');
        return Number(reversed); // 뒤집은 값을 숫자로 변환
    }

    // 숫자가 소수인지 확인하는 함수
    function isPrime(number) {
        // 1 이하의 숫자는 소수가 아님
        if (number <= 1) {
            return false;
        }

        // 2와 3은 소수
        if (number <= 3) {
            return true;
        }

        // 짝수와 3의 배수 제외
        if (number % 2 === 0 || number % 3 === 0) {
            return false;
        }

        for (let i = 5; i * i <= number; i += 6) {
            if (number % i === 0 || number % (i + 2) === 0) {
                return false;
            }
        }

        return true;
    }

    return arr.map(reverseNumber)
        .filter(isPrime);
};

let arr = [32, 55, 62, 20, 250, 370, 200, 30, 100];
console.log(solution(arr));
