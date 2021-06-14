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
}
