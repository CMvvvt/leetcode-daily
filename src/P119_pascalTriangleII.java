public class P119_pascalTriangleII {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> pre = new ArrayList<>();
            for(int i = 0; i <= rowIndex; i++) {
                List<Integer> cur = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    if(j == i || j == 0) {
                        cur.add(1);
                    } else  {
                        cur.add(pre.get(j) + pre.get(j-1));
                    }
                }
                pre = cur;
            }
            return pre;
        }
    }
}
