public class P57_insertIntervals {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if(intervals.length == 0) {
                return new int[][]{{newInterval[0],newInterval[1]}};
            }
            int start = newInterval[0];
            int end = newInterval[1];
            int i = 0;
            int len = intervals.length;
            List <int[]> res = new ArrayList<int[]>();
            while(i < len && intervals[i][1] < start) {
                res.add(intervals[i]);
                i++;
            }
            while(i < len && end >= intervals[i][0]) {
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
                i++;
            }
            res.add(new int[]{start,end});
            while(i < len) {
                res.add(intervals[i]);
                i++;
            }
            return res.toArray(new int[0][]);
        }
    }
}
