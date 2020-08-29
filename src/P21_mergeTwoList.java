import static org.junit.Assert.*;
import org.junit.Test;

import javax.print.attribute.standard.SheetCollate;
import java.util.*;



public class P21_mergeTwoList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists_method1(ListNode l1, ListNode l2) {
       ListNode res = new ListNode(0);
       ListNode resHead = res;
       while(l1 != null && l2 != null) {
           if (l1.val <= l2.val) {
               resHead.next = l1;
               l1 = l1.next;
           } else {
               resHead.next = l2;
               l2 = l2.next;
           }
           resHead = resHead.next;

       }
       resHead.next = l1 == null ? l2 : l1;

       return res.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next =  mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
