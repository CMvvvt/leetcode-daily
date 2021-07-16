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
}
