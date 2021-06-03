public class P160_intersectionOfTwoLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            while(headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while(headB != null) {
                if(set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode head1 = headA;
            ListNode head2 = headB;
            while(head1 != head2) {
                if(head1 != null) {
                    head1 = head1.next;
                } else {
                    head1 = headB;
                }
                if(head2 != null) {
                    head2 = head2.next;
                } else {
                    head2 = headA;
                }
            }
            return head1;
        }
    }
}
