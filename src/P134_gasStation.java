public class P134_gasStation {
    class Solution {
        int len, res;
        public int canCompleteCircuit(int[] gas, int[] cost) {
            len = gas.length;
            res = -1;
            for(int i = 0; i < len; i++) {
                if(cost[i] > gas[i]) continue;
                if(canMake(gas, cost, i)) {
                    return res;
                }
            }
            return res;
        }
        private boolean canMake(int[] gas, int[] cost, int start) {
            int gasRemain = gas[start];
            int gasCost = cost[start];
            for(int i = start; i < len; i++) {
                if(gasRemain < gasCost) return false;
                if(i == len - 1) {
                    gasRemain = gasRemain - gasCost + gas[0];
                    gasCost = cost[0];
                } else {
                    gasRemain = gasRemain - gasCost + gas[i+1];
                    gasCost = cost[i+1];
                }

            }
            for(int i = 0; i < start; i++) {
                if(gasRemain < gasCost) return false;
                if(i == start - 1) {
                    res = start;
                    return true;
                } else {
                    gasRemain = gasRemain - gasCost + gas[i+1];
                    gasCost = cost[i+1];
                }

            }
            res = start;
            return true;
        }
    }
}
