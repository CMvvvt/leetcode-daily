public class P116_populatingNextRightPointer {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if(root == null) return root;
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int n = queue.size();
                for(int i = 0; i < n; i++) {
                    Node node = queue.pollFirst();
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                    if(i == n-1) {
                        node.next = null;
                    } else {
                        node.next = queue.peekFirst();
                    }
                }
            }
            return root;
        }
    }
}
