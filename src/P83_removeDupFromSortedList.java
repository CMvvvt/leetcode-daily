public class P83_removeDupFromSortedList {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode point = head;
            if(head == null) return null;
            while(point.next != null) {
                if(point.val == point.next.val) {
                    point.next = point.next.next;
                }else{
                    point = point.next;
                }
            }
            return head;
        }
    }
}
