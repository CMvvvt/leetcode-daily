public class P51_nqueens {
    class Solution {


        public List<List<String>> solveNQueens(int n) {
            boolean[] diag1 = new boolean[2*n - 1];
            boolean[] diag2 = new boolean[2*n - 1];
            boolean[] col = new boolean[n];
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> queen = new ArrayList<String>();
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            generateQueens(n,0,queens, res, col, diag1, diag2);
            return res;
        }


        private boolean available(int x,int y,int n,boolean[] col, boolean[] diag1, boolean[] diag2 ) {
            return !diag1[x+y] && !diag2[y-x+n-1] && !col[y];
        }

        private void updateBoard(int x, int y, int n, boolean is_put, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2) {
            col[y] = is_put;
            diag1[x+y] = is_put;
            diag2[y-x+n-1] = is_put;
            queens[x] = is_put ? y : -1;
        }

        public void generateQueens(int n, int x, int[] queens,  List<List<String>> res, boolean[] col, boolean[] diag1, boolean[] diag2) {
            if(x == n) {
                res.add(generateBoard(queens, n));
                return;
            }
            for(int y = 0; y < n; y++) {
                if(!available(x,y,n,col,diag1,diag2)) continue;
                updateBoard(x,y,n,true,queens,col,diag1,diag2);
                generateQueens(n,x+1, queens, res,col,diag1,diag2);
                updateBoard(x,y,n,false,queens,col,diag1,diag2);
            }
        }

        public List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for(int i = 0; i<n; i++){
                char[] row = new char[n];
                Arrays.fill(row,'.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }
}
