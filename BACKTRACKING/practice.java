import java.util.ArrayList;
import java.util.List;

class practice{

    // n queens problem on leetcode no.51


        // ye function keval ye check karta hai ki queen uper vale coln per baith payegi kai nahi
    public boolean isSafe(char board[][],int row, int coln){
        
        // ye uper row check karta hai kahi queen upr to nahi baithi hai


        for(int i = row-1;i>=0;i--){ 
            if (board[i][coln]=='Q') {
                return false;
            }
        }


         // ye loop diagonal left up check krta hai 


        for(int i = row-1,j=coln-1;i>=0 &&j>=0;i--,j--){
            if (board[i][j]=='Q') {
                return false;
            }
        }

        // ye diagonal right up check karta hai aur ye dekhta hai ki upr vale row aur badhte hue coln me kahi queen to nahi baithi hai
         for(int i = row-1,j=coln+1;i>=0 &&j<board.length;i--,j++){ 
            if (board[i][j]=='Q') {
                return false;
            }
        }
            return true;
    }
    public  void solve(char board[][],int row,  List<List<String>> ans){
        
        
        // base condition 

        if (row==board.length) {
            List<String>temp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return ;
        }

            
        // ye condition dekhti hai ki aage aane vale usi row me coln me kahi queen baithi to nai hai

        for (int coln = 0; coln < board.length; coln++) {
            
            // ye condition check karta hai queen coln me baith sakti hai ki nahi
            if (isSafe(board,row,coln)) {
                board[row][coln] = 'Q';

                // recursion
                solve(board, row+1, ans);

                // backtracking


                board[row][coln] = '.';
            }
        }
    }

    public List<List<String>> SolveQueen(int n){
        List<List<String>> ans = new ArrayList<>();

    //    board bnate hai jitni queen hogi utne by utne ka board bnega

        char[][]board = new char[n][n];


        // row no. 0 se start karte hai yaani pahle row se 
        int row = 0; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]  = '.';
            }
        }
        solve(board,row,ans);
        return ans;
    }


    // grid ways quetion

    public int CountWays(int i, int j ,int n, int m){


        if (i==n-1 && j==m-1) {
            return 1;
        }

        if (i==n || j ==m) {
            return 0;
        }
        int w1 = CountWays(i+1, j, n, m);
        int w2 = CountWays(i, j+1, n, m);
        return w1+w2;
    }
}
    

