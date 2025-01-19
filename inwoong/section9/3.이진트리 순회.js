const binaryTreeTraversal = () => {
  const tree = {
    value: 1,
    left: { value: 2, left: { value: 4 }, right: { value: 5 } },
    right: { value: 3, left: { value: 6 }, right: { value: 7 } },
  };

  const preOrder = (node) => {
    if (!node) return;
    console.log(node.value);
    preOrder(node.left);
    preOrder(node.right);
  };

  const inOrder = (node) => {
    if (!node) return;
    inOrder(node.left);
    console.log(node.value);
    inOrder(node.right);
  };

  const postOrder = (node) => {
    if (!node) return;
    postOrder(node.left);
    postOrder(node.right);
    console.log(node.value);
  };

  console.log("전위순회:");
  preOrder(tree);
  console.log("중위순회:");
  inOrder(tree);
  console.log("후위순회:");
  postOrder(tree);
};

binaryTreeTraversal();
