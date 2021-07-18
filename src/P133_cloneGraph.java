public class P133_cloneGraph {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {
        Map<Node, Node> map = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null) return node;

            if(map.containsKey(node)) {
                return map.get(node);
            }

            Node cloneNode = new Node(node.val, new ArrayList<>());
            map.put(node, cloneNode);

            for(Node neighbor: node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }

            return cloneNode;
        }
    }


    /**
     *  bfs method
     */
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {
        public Node cloneGraph(Node node) {
            if(node == null) return node;
            Map<Node, Node> visited = new HashMap<>();

            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            visited.put(node, new Node(node.val, new ArrayList<>()));
            while(! queue.isEmpty()) {
                Node n = queue.poll();
                for(Node neighbor: n.neighbors) {
                    if(! visited.containsKey(neighbor)) {
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.add(neighbor);
                    }
                    visited.get(n).neighbors.add(visited.get(neighbor));
                }
            }
            return visited.get(node);

        }
    }
}
