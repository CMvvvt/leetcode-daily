import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class P24_swapPairs {
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

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    @Test
    public void test() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
    }
}
