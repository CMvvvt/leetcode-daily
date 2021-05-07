public class P118_pascalTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < numRows; i++) {
                List<Integer> path = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        path.add(1);
                    } else {
                        path.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                    }
                }
                res.add(path);
            }
            return res;
        }
    }
}
