public class P37_solveSudoku {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for(int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
            if (board[row][i] == num) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }

    private boolean helper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') {
                    for(char num = '1'; num <= '9'; num++){
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if(helper(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}
