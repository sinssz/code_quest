const solution = (str) => {
    const toLowerCase = str.toLowerCase();
    const reversed = toLowerCase.split('').reverse().join('');

    if (toLowerCase === reversed) {
        return "YES"
    }

    return "NO";
}

console.log(solution("gooG"));  // YES
console.log(solution("goG"));   // YES
console.log(solution("man"));   // NO
