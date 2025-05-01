const solution = (str) => {
    const toLowerCase = str.toLowerCase().replace(/[^a-z]/g, '');
    const reversed = toLowerCase.split('').reverse().join('');

    if (toLowerCase === reversed) {
        return "YES"
    }

    return "NO";
}

console.log(solution("found7, time: study; Yduts; emit, 7Dnuof"));  // YES
