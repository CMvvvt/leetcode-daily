/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 * 94. 二叉树的中序遍历
 */
var inorderTraversal = function(root) {
    let result = []
    const inOrder = (root) => {
        if(!root) {
            return
        }
        inOrder(root.left);
        result.push(root.val);
        inOrder(root.right);
    }
    inOrder(root);
    return result;
};

// method 2 使用栈方法；
// 把中序递归的问题理解成栈，向左迭代(入栈)直到没有左子节点(出栈)
var inorderTraversal1 = function(root) {
    let result = [];
    let stack = [];
    while(root || stack.length) {
        while(root) {
            stack.push(root);
            root = root.left
        }
        root = stack.pop();
        result.push(root.val);
        root = root.right;
    }
    return result;
};