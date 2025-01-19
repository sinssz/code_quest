const toBinary = (n) => {
  const dfs = (num) => {
    if (num === 0) return;
    dfs(Math.floor(num / 2));
    console.log(num % 2);
  };
  dfs(n);
};

toBinary(11); // 출력: 1 0 1 1 (줄바꿈으로 출력됨)
