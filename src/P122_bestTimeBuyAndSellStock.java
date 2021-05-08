public class P122_bestTimeBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxGross = 0;
            for(int i = 0; i < prices.length; i++) {
                if(prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if(prices[i] - minPrice > maxGross) {
                    maxGross = prices[i] - minPrice;
                }
            }
            return maxGross;
        }
    }
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0;
            int dp1 = - prices[0];
            for(int i = 0; i < n; i++) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return Math.max(dp0, dp1);
        }
    }
}
