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


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     * REMOVE TWICE
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = reverse(head);
            ListNode dummyHead = new ListNode(-1, newHead);
            ListNode dummy = dummyHead;
            while(n > 1) {
                dummy = dummy.next;
                n--;
            }
            dummy.next = dummy.next.next;
            return reverse(dummyHead.next);
        }
        private ListNode reverse(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
