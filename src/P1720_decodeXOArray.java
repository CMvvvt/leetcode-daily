public class P1720_decodeXOArray {
    class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] res = new int[encoded.length+1];
            res[0] = first;
            for(int i = 1; i < res.length; i++) {
                res[i] = first ^ encoded[i-1];
                first = res[i];
            }
            return res;
        }
    }
}
