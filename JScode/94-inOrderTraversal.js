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