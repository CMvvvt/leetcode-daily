public class P589_NaryTreePreorderTraversal {
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

    class Solution1 {
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            pre(root, list);
            return list;
        }

        private void pre(Node root, List<Integer> list) {
            if(root == null) return;
            list.add(root.val);
            List<Node> children = root.children;
            for(int i = 0; i < children.size(); i++) {
                pre(children.get(i), list);
            }
            return;
        }
    }
}
