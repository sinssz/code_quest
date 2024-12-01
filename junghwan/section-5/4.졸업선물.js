const solution = (m, product) => {
  let answer = 0;
  let n = product.length;

  for (let i = 0; i < n; i++) {
    let money = m;
    let cnt = 0;

    let discountedPrice = product[i][0] / 2 + product[i][1];
    money -= discountedPrice;
    cnt++;

    // 나머지 상품들을 가격+배송비 기준으로 정렬
    let others = product
      .filter((_, index) => index !== i)
      .sort((a, b) => a[0] + a[1] - (b[0] + b[1]));

    for (let [price, delivery] of others) {
      if (money >= price + delivery) {
        money -= price + delivery;
        cnt++;
      } else break;
    }

    answer = Math.max(answer, cnt);
  }

  return answer;
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
