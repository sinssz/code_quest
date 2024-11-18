const visibleStudent = (arr) => {
  let count = 0;
  let max = 0;
  for (const height of arr) {
    if (height > max) {
      max = height;
      count++;
    }
  }
  return count;
};

console.log(visibleStudent([130, 135, 148, 140, 145, 150, 150, 153]));
