public class P56_mergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });
            List<int[]> merged = new ArrayList<int[]>();

            for(int i = 0; i < intervals.length; i++){
                int start = intervals[i][0];
                int end = intervals[i][1];
                if( merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                    merged.add(new int[]{start, end});
                }else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }




}
