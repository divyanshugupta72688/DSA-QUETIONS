import java.util.*;
public class practise {
    public static void solve(char board[][],int row,List<List<String>>ans ){
        if (row==board.length) {
            List<String>temp = new ArrayList<>();
            for(int i = 0;i<board.length;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int coln=0;coln<board.length;coln++){
            if (issafe(board,row,coln)) {
                board[row][coln] = 'Q';
                solve(board, row+1, ans);
                board[row][coln] = '.';
            }
        }
    }
    public List<List<String>>Solve(int n){
        List<List<String>>ans  = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j] = '.';
            }
        }
        solve(board,0,ans);
    }
}
