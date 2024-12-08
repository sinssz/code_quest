const compareMaps = (map1, map2) => {
  if (map1.size !== map2.size) return false;
  for (let [key, val] of map1) {
    if (!map2.has(key) || map2.get(key) !== val) return false;
  }
  return true;
};

const solution = (s, t) => {
  let answer = 0;
  let tH = new Map();
  let sH = new Map();

  for (let x of t) {
    tH.set(x, (tH.get(x) || 0) + 1);
  }

  for (let i = 0; i < t.length - 1; i++) {
    sH.set(s[i], (sH.get(s[i]) || 0) + 1);
  }

  let lt = 0;
  for (let rt = t.length - 1; rt < s.length; rt++) {
    sH.set(s[rt], (sH.get(s[rt]) || 0) + 1);
    if (compareMaps(sH, tH)) answer++;

    sH.set(s[lt], sH.get(s[lt]) - 1);
    if (sH.get(s[lt]) === 0) sH.delete(s[lt]);
    lt++;
  }

  return answer;
};

console.log(solution("bacaAacba", "abc")); // 3
