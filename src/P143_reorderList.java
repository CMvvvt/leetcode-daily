public class P143_reorderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if(head == null) return;
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while(node != null) {
                list.add(node);
                node = node.next;
            }
            int n = list.size();
            int i = 0, j = n - 1;
            while(i < j) {
                list.get(i).next = list.get(j);
                i++;
                if(i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
            return;
        }
    }
}
