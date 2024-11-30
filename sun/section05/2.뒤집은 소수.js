const solution = (arr) => {
    // 숫자를 뒤집는 함수
    function reverseNumber(number) {
        const reversed = String(number)
            .split('')
            .reverse()
            .join('');
        return Number(reversed); // 뒤집은 값을 숫자로 변환
    }

    function isPrime(number) {
        if (number <= 1) return false;

        for (let i = 2; i <= Math.sqrt(number); i++) {
            if (number % i === 0) {
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
