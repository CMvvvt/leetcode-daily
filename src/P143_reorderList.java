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
            ListNode dummy = head;
            while(dummy != null) {
                dummy.next = reverse(dummy.next);
                dummy = dummy.next;
            }
            return;
        }
        private ListNode reverse(ListNode head) {
            if(head == null) return head;
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
