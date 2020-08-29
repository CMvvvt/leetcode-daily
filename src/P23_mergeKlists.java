import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P23_mergeKlists {

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

    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0 ) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < k; i++) {
            if(lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while(queue.size() != 0) {
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if(node.next != null) {
                queue.add(node.next);
            }
        }

        head.next = null;
        return dummy.next;
    }
}
