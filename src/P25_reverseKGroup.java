import java.util.List;

public class P25_reverseKGroup {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int value) {
            this.val = value;
        }
        ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = dummy;

        while(next.next != null) {
            for(int i = 0; i < k && next != null; i++){
                next = next.next;
            }
            if(next == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode end = next.next;
            next.next = null;
            prev.next = reverse(start);
            start.next = end;
            prev = start;
            next = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


}
