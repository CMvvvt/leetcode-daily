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

    class Solution2 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for(int i = 0; i <= rowIndex; i++) {
                for(int j = i; j > 0; j--) {
                    if(j == i)  {
                        res.add(1);
                    } else {
                        res.set(j, res.get(j) + res.get(j-1));
                    }
                }
            }
            return res;
        }
    }
}
