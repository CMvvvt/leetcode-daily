public class P374_guessNumberHigherOrLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            return helper(1, n);
        }

        private int helper(int low, int high) {
            int mid = low + (high-low) / 2;
            if(guess(mid) == 0) return mid;
            if(guess(mid) < 0) return helper(low, mid-1);
            return helper(mid+1, high);
        }
    }
}
