const solution = (str) => {
    const extracted = str.match(/\d+/g)?.join("") || "0";
    return Number(extracted);
}

console.log(solution("g0en2T0s8eSoft"));  // 208
