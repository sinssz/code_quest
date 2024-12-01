const solution = (totalPrice, arr) => {
  const studentCount = arr.length;
  const sortedArr = arr.sort((a, b) => a[0] - b[0]);
  let result = 0;

  for (let i = 0; i < studentCount; i++) {
    let temp = [];
    let cnt = 1;
    const [fixPrice, firShippingPrice] = sortedArr[i];
    const salePrice = fixPrice / 2;
    const fixSum = salePrice + firShippingPrice;
    let restPrice = totalPrice - fixSum;

    for (let j = 0; j < studentCount; j++) {
      if (i === j) continue;

      const [price, shippingPrice] = sortedArr[j];
      if (restPrice >= price + shippingPrice) {
        cnt++;
        restPrice -= price + shippingPrice;
        temp.push([i, j]);
      } else {
        break;
      }
    }
    result = Math.max(result, cnt);
  }

  return result;
};

console.log(
  solution(28, [
    [6, 6],
    [2, 2],
    [4, 3],
    [4, 5],
    [10, 3],
  ])
);
