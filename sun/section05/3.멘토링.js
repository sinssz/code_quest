const solution = (students, exams) => {

    // 두 명씩 짝지음 (순서를 고려하여)
    function generatePairs(n) {
        const pairs = [];

        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (i !== j) {  // 자신과 짝지어지지 않도록
                    pairs.push([i, j]);
                }
            }
        }

        return pairs;
    }

    let result = [];
    const pairs = generatePairs(students);

    for (const pair of pairs) {
        // console.log(pair);
        const mentor = pair[0];
        const mentee = pair[1];
        let isValid = true;

        for (const exam of exams) {
            const indexOfMentor = exam.indexOf(mentor);
            // console.log('mentor: ' + indexOfMentor);
            const indexOfMentee = exam.indexOf(mentee);
            // console.log('mentee: ' + indexOfMentee);

            // index가 낮을 수록 성적이 좋음
            // 멘티가 멘토보다 성적이 좋은 경우는 불가능
            if (indexOfMentee < indexOfMentor) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            result.push(pair);
        }
    }

    // console.log(result);

    return result.length;
};

let students = 4
let exams = [[3, 4, 1, 2], [4, 3, 2, 1], [3, 1, 4, 2]];
console.log(solution(students, exams));
