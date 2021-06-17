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
            ListNode mid = getMid(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverse(l2);
            mergeList(l1, l2);
        }
        private ListNode reverse(ListNode head) {
            if(head == null) {
                return head;
            }
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
        private void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_temp;
            ListNode l2_temp;
            while(l1 != null && l2 != null) {
                l1_temp = l1.next;
                l2_temp = l2.next;

                l1.next = l2;
                l1 = l1_temp;

                l2.next = l1;
                l2 = l2_temp;
            }
        }
        private ListNode getMid(ListNode head) {
            ListNode slow = head, fast = head;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
