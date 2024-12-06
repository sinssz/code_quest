const solution = (s, t) => {
  let result = 0;
  const sHash = new Map();
  const tHash = new Map();

  // 비교 기준 해시 생성
  for (let i = 0; i < t.length; i++) {
    if (tHash.has(t[i])) {
      tHash.set(t[i], tHash.get(t[i]) + 1);
    } else {
      tHash.set(t[i], 1);
    }
  }

  // 비교 대상 해시 초기화
  for (let i = 0; i < t.length - 1; i++) {
    if (sHash.has(s[i])) {
      sHash.set(s[i], sHash.get(s[i]) + 1);
    } else {
      sHash.set(s[i], 1);
    }
  }

  // 투포인터
  let lt = 0;
  for (let rt = t.length - 1; rt < s.length; rt++) {
    if (sHash.has(s[rt])) {
      sHash.set(s[rt], sHash.get(s[rt]) + 1);
    } else {
      sHash.set(s[rt], 1);
    }

    if (compareMap(sHash, tHash)) {
      result++;
    }

    sHash.set(s[lt], sHash.get(s[lt]) - 1);
    if (sHash.get(s[lt]) === 0) {
      sHash.delete(s[lt]);
    }
    lt++;
  }

  return result;
};

const compareMap = (map1, map2) => {
  //   console.log(map1, map2);
  if (map1.size !== map2.size) return false;

  for (let [key, value] of map1) {
    if (!map2.has(key)) return false;
    if (map2.get(key) !== value) return false;
  }
  return true;
};

console.log(solution("bacaAacba", "abc"));
