public class P146_LRUCache {
    class LRUCache {
        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;
            public LinkedNode() {}
            public LinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }
        private  Map<Integer, LinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private LinkedNode head, tail;
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }
        public int get(int key) {
            LinkedNode node = cache.get(key);
            if(node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if(node == null) {
                LinkedNode newNode = new LinkedNode(key, value);
                cache.put(key, newNode);
                newNode.prev = head;
                newNode.next = head.next;
                head.next.prev = newNode;
                head.next = newNode;
                ++size;
                if(size > capacity) {
                    LinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        public LinkedNode removeTail() {
            LinkedNode res = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return res;
        }

        public void moveToHead(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */git
}
