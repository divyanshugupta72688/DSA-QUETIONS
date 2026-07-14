class Nqueen {

    public static boolean isSafe(char board[][], int row,int coln){
        // verticle up
        for(int i=row-1;i>=0;i--){
            if (board[i][coln]=='Q') {
                return false;
            }
        }
        // DIAGONAL LEFT

            for(int i =row-1,j=coln-1;i>=0 && j>=0;i--,j--){
             if (board[i][j]=='Q') {
                return false;
             }   
            }

            // DIAGONAL RIGHT

            for(int i =row-1,j=coln+1;i>=0 && j<board.length;i--,j++){
             if (board[i][j]=='Q') {
                return false;
             }   
            }
            return true;
    }
    public static void nQueen(char board[][], int row) {

        if (row == board.length) {
            printboard(board);
            System.out.println();
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board,row,j)) {
                board[row][j] = 'Q';

            nQueen(board, row + 1);

            board[row][j] = 'x';
            }
        }
    }

    public static void printboard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("-----------CHESS BOARD------------");

        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        nQueen(board, 0);
    }
}