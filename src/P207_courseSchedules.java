public class P207_courseSchedules {
    class Solution1 {
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

    /**
     *  bfs method
     */
    class Solution2 {
        List<List<Integer>> edges;
        int[] indegs;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            indegs = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList(i));
            }
            for(int[] pre: prerequisites) {
                edges.get(pre[1]).add(pre[0]);
                indegs[pre[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++) {
                if(indegs[i] == 0) {
                    queue.offer(i);
                }
            }
            int visited = 0;
            while(! queue.isEmpty()) {
                visited++;
                int index = queue.poll();
                for(int v: edges.get(index)) {
                    indegs[v]--;
                    if(indegs[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            return visited == numCourses;
        }
    }


    /**
     * backtracking method
     * time limited
     */
    class Solution3 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

            for(int[] relation: prerequisites) {
                if(courseDict.containsKey(relation[1])) {
                    courseDict.get(relation[1]).add(relation[0]);
                } else {
                    List<Integer> nextCourse = new LinkedList<>();
                    nextCourse.add(relation[0]);
                    courseDict.put(relation[1], nextCourse);
                }
            }

            boolean[] path = new boolean[numCourses];

            for(int currCourse = 0; currCourse < numCourses; currCourse++) {
                if(isCycle(currCourse, courseDict, path)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isCycle(int currCourse, Map<Integer, List<Integer>> courseDict, boolean[] path) {
            if(path[currCourse]) return true;
            if(! courseDict.containsKey(currCourse)) return false;
            path[currCourse] = true;
            boolean res = false;
            for(int nextCourse: courseDict.get(currCourse)) {
                res = isCycle(nextCourse, courseDict, path);
                if(res) break;
            }
            path[currCourse] = false;
            return res;
        }
    }
}
