const fn = (arr) => {
  let 현수인덱스 = null;
  let 짝궁인덱스 = null;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i + 1] < arr[i]) {
      if (!현수인덱스) 현수인덱스 = i + 1;
    }
    if (arr[i + 1] === arr[i]) {
      if (!현수인덱스) 현수인덱스 = i + 1;
      i += 1;
    }
    if (arr[i + 1] > arr[i]) {
      if (현수인덱스) 짝궁인덱스 = i + 1;
    }
  }

  return [현수인덱스, 짝궁인덱스];
};

fn([120, 130, 150, 150, 130, 150]);
