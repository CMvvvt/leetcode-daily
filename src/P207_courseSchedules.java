public class P207_courseSchedules {
    class Solution {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            visited = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList(i));
            }
            for(int[] pre: prerequisites) {
                edges.get(pre[1]).add(pre[0]);
            }
            for(int i = 0; i < numCourses && valid; i++) {
                if(visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }
        private void dfs(int u) {
            visited[u] = 1;
            for(int v: edges.get(u)) {
                if(visited[v] == 0) {
                    dfs(v);
                    if(!valid) {
                        return;
                    }
                } else if(visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            visited[u] = 3;
        }
    }
}
