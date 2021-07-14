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
     * method 2
     */
    class Node {
        public int key, value;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    class DoubleLinkedList {

        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }


    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleLinkedList cache;
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleLinkedList();
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            int val = map.get(key).value;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if(map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(node);
                map.put(key, node);
            } else {
                if(cap == cache.size()) {
                    Node removeNode = cache.removeLast();
                    map.remove(removeNode.key);
                }
                cache.addFirst(node);
                map.put(key, node);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */git
}
