public class P547_numOfProvinces {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int numbers = isConnected.length;
            boolean[] visited = new boolean[numbers];
            int provinces = 0;
            for(int i = 0; i < numbers; i++) {
                if(! visited[i]) {
                    dfs(isConnected, visited, i, numbers);
                    provinces++;
                }
            }
            return provinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i, int numbers) {
            for(int j = 0; j < numbers; j++) {
                if(isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, j, numbers);
                }
            }
            return;
        }
    }


    /**
     *  breadth first search method added
     */
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int numbers = isConnected.length;
            int provinces = 0;
            boolean[] visited = new boolean[numbers];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numbers; i++) {
                if(! visited[i]) {
                    queue.offer(i);
                    while(! queue.isEmpty()) {
                        int j = queue.poll();
                        visited[j] = true;
                        for(int k = 0; k < numbers; k++) {
                            if(isConnected[j][k] == 1 && ! visited[k]) {
                                queue.offer(k);
                            }
                        }
                    }
                    provinces++;
                }
            }
            return provinces;
        }
    }


    /**
     * Union Find method added
     */
    class UnionFind {
        private Map<Integer, Integer> father;
        private int setsNum;
        public UnionFind() {
            father = new HashMap<>();
            setsNum = 0;
        }

        public void add(int x) {
            if(! father.containsKey(x)) {
                father.put(x, null);
                setsNum++;
            }

        }

        public int find(int x) {
            int root = x;

            while(father.get(root) != null) {
                root = father.get(root);
            }

            while(x != root) {
                int originFather = father.get(x);
                father.put(x, root);
                x = originFather;
            }

            return root;
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY) {
                father.put(rootX, rootY);
                setsNum--;
            }

        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int size() {
            return setsNum;
        }
    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int numbers = isConnected.length;
            UnionFind union = new UnionFind();
            for(int i = 0; i < numbers; i++) {
                union.add(i);
                for(int j = 0; j < i; j++) {
                    if(isConnected[i][j] == 1) {
                        union.merge(i, j);
                    }
                }
            }
            return union.size();
        }
    }
}
