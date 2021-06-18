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


    class Solution2 {
        public List<Integer> preorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(! stack.isEmpty()) {
                Node node = stack.pop();
                list.add(node.val);
                Collections.reverse(node.children);
                for(Node child: node.children) {
                    stack.push(child);
                }
            }
            return list;
        }
    }

}
