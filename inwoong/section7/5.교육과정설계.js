const fn = (essential, plan) => {
  const essentialArr = essential.split("");
  const planArr = plan.split("");

  while (!!planArr.length) {
    if (planArr.pop() === essentialArr[essentialArr.length - 1])
      essentialArr.pop();
  }

  if (!!essentialArr.length) return "NO";
  return "YES";
};

fn("CBA", "CDBAGE");
