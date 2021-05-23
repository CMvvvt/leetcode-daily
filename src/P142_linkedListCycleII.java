public class P142_linkedListCycleII {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) return null;
            Set<ListNode> set = new HashSet<>();
            while(head != null) {
                if(!set.contains(head)) {
                    set.add(head);
                    head = head.next;
                } else {
                    return head;
                }
            }
            return null;
        }
    }
}
