public class P138_copyListWithRandomPointer {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            Node root = new Node(0);
            Node dummy = root;
            Node root2 = root;
            Node dummyHead = head;
            Node dummyHead2 = head;
            if(head == null) return null;
            int len = 0;
            while(head != null) {
                len++;
                head = head.next;
            }
            int[] arr = new int[len];
            Map<Integer, Node> map = new HashMap<>();
            for(int i = 0; i < len; i++) {
                root.val = i;
                if(i == len - 1) {
                    root.next = null;
                } else {
                    root.next = new Node(i);
                }
                map.put(i, root);
                arr[i] = dummyHead2.val;
                dummyHead2.val = i;
                root = root.next;
                dummyHead2 = dummyHead2.next;
            }

            for(int i = 0; i < len; i++) {
                if(dummyHead.random == null) {
                    root2.random = null;
                    root2.val = arr[i];
                } else {
                    root2.random = map.get(dummyHead.random.val);
                    root2.val = arr[i];
                }
                root2 = root2.next;
                dummyHead = dummyHead.next;
            }

            return dummy;

        }
    }


    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution2 {
        Map<Node, Node> visitedMap = new HashMap<>();
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            if(this.visitedMap.containsKey(head)) {
                return this.visitedMap.get(head);
            }

            Node node = new Node(head.val, null, null);

            this.visitedMap.put(head, node);

            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);

            return node;
        }
    }
}
