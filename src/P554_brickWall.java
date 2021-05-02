public class P554_brickWall {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(List<Integer> width: wall) {
                int n = width.size();
                int sum = 0;
                for(int i = 0; i < n - 1; i++) {
                    sum += width.get(i);
                    map.put(sum, map.getOrDefault(sum, 0)+1);
                }
            }
            int maxWidth = 0;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                maxWidth = Math.max(maxWidth, entry.getValue());
            }
            return wall.size() - maxWidth;
        }
    }
}
