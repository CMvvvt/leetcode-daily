public class P79_wordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    boolean flag =  check(board, visited, i, j, word, 0);
                    if(flag) return true;
                }
            }
            return false;
        }

        public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int place) {
            if(board[i][j] != word.charAt(place)) return false;
            if(place == word.length()-1) return true;

            boolean res = false;
            visited[i][j] = true;
            int[][] routes = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] route: routes) {
                int newI = i + route[0];
                int newJ = j + route[1];
                if(newI >= 0 && newI < board.length && newJ >=0 && newJ < board[0].length) {
                    if(!visited[newI][newJ]) {
                        res = check(board, visited, newI, newJ, word, place+1);
                        if(res) break;
                    }
                }
            }
            visited[i][j] = false;
            return res;
        }
    }
}
