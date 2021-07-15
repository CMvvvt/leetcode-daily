public class P210_courseSchedulesII {
    class Solution {
        List<Integer> list;
        List<List<Integer>> edges;
        int[] indegs;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            list = new ArrayList<>();
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
            while(! queue.isEmpty()) {
                int index = queue.poll();
                list.add(index);
                for(int v: edges.get(index)) {
                    indegs[v]--;
                    if(indegs[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            if(list.size() < numCourses) {
                return new int[0];
            }
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                res[i] = list.remove(0);
            }
            return res;
        }
    }


    /**
     * second time
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }

            for(int[] pre: prerequisites) {
                indegrees[pre[0]]++;
                adjacency.get(pre[1]).add(pre[0]);
            }

            for(int i = 0; i < numCourses; i++) {
                if(indegrees[i] == 0) queue.add(i);
            }

            while(! queue.isEmpty()) {
                int index = queue.poll();
                res.add(index);
                numCourses--;
                for(int cur: adjacency.get(index)) {
                    indegrees[cur]--;
                    if(indegrees[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
            int[] ans = new int[res.size()];
            for(int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return numCourses != 0? new int[0]: ans;
        }
    }
}
