public class P257_binaryTreePaths {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            construct(root, "", list);
            return list;
        }

        private void construct(TreeNode root, String str, List<String> list) {
            if(root != null) {
                StringBuffer sb = new StringBuffer(str);
                sb.append(String.valueOf(root.val));
                if(root.left == null && root.right == null) {
                    list.add(sb.toString());
                } else {
                    sb.append("->");
                    construct(root.left, sb.toString(), list);
                    construct(root.right, sb.toString(), list);
                }
            }
            return;
        }
    }
}
