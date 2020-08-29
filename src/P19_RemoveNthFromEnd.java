import static org.junit.Assert.*;
import org.junit.Test;

import javax.print.attribute.standard.SheetCollate;
import java.util.*;


public class P19_RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null) {
            length ++;
            node = node.next;
        }
        return  length;
    }

    public ListNode removeNthFromEnd_method1(ListNode head, int n) {
        int length = getLength(head);
        int fromStart = length - n;
        int i = 0;
        ListNode node = head;
        if(fromStart <= 0){
            return head.next;
        }
        while(i < fromStart-1){
            node = node.next;
            i++;
        }
        node.next = node.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {return head;}
         ListNode p = new ListNode(0);
        ListNode q = new ListNode(0);
        p.next = head;
        q.next = head;
        for(int i = 0; i < n; i++) {
            q = q.next;
        }
        if(q == null || q.next == null) {
            return head.next;
        }
        while(q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }


}
