const fn = (princes, num) => {
  let princesArr = Array.from({ length: princes }, (_, i) => i + 1);

  let stack = [];

  let count = 1;
  while (princesArr.length > 1) {
    if (count === num) {
      princesArr.shift();
      count = 1;
      princesArr = [...princesArr, ...stack];
      stack = [];
    } else {
      stack.push(princesArr.shift());
      count += 1;
    }
  }

  return princesArr[0];
};

fn(8, 3);
