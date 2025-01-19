const bfsBinaryTree = () => {
  const tree = {
    value: 1,
    left: { value: 2, left: { value: 4 }, right: { value: 5 } },
    right: { value: 3, left: { value: 6 }, right: { value: 7 } },
  };

  const queue = [tree];
  while (queue.length) {
    const node = queue.shift();
    console.log(node.value);
    if (node.left) queue.push(node.left);
    if (node.right) queue.push(node.right);
  }
};

bfsBinaryTree();
