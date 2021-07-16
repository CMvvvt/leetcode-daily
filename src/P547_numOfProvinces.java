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
}
