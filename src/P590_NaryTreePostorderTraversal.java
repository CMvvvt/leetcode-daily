public class P590_NaryTreePostorderTraversal {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    /**
     * recursion
     */
    class Solution1 {
        public List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            post(root, list);
            return list;
        }
        private void post(Node node, List<Integer> list) {
            if(node == null) return;
            List<Node> children = node.children;
            for(int i = 0; i < children.size(); i++) {
                post(children.get(i), list);
            }
            list.add(node.val);
            return;
        }
    }
}
