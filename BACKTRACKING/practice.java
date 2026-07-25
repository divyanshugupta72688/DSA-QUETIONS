
import java.util.*;

class practice{


    // rate in maze problem 

    public boolean isSafe(int[][]maze,int newsrcx,int newsrcy,int n,boolean[][]visited){
        if (newsrcx<0 || newsrcx>=n||newsrcy<0 ||newsrcy>=n) {
            return false;
        }
        if (maze[newsrcx][newsrcy]==0) {
            return false;
        }
        if (visited[newsrcx][newsrcy]) {
            return false;
        }
        return true;
    }

   public void solve(int[][] maze,
                  int srcx,
                  int srcy,
                  int destx,
                  int desty,
                  ArrayList<String> ans,
                  boolean[][] visited,
                  String path){

    if(srcx==destx && srcy==desty){
        ans.add(path);
        return;
    }

    int n = maze.length;

    visited[srcx][srcy]=true;

    // Up
    if(isSafe(maze,srcx-1,srcy,n,visited)){
        solve(maze,srcx-1,srcy,destx,desty,ans,visited,path+"U");
    }

    // Down
    if(isSafe(maze,srcx+1,srcy,n,visited)){
        solve(maze,srcx+1,srcy,destx,desty,ans,visited,path+"D");
    }

    // Left
    if(isSafe(maze,srcx,srcy-1,n,visited)){
        solve(maze,srcx,srcy-1,destx,desty,ans,visited,path+"L");
    }

    // Right
    if(isSafe(maze,srcx,srcy+1,n,visited)){
        solve(maze,srcx,srcy+1,destx,desty,ans,visited,path+"R");
    }

    // Backtracking
    visited[srcx][srcy]=false;
}

    public ArrayList<String>Rate(int[][]maze){
        ArrayList<String>ans = new ArrayList<>();
        if (maze[0][0]==0) {
            return ans;
        }
        int n = maze.length;
        boolean[][]visited = new boolean[n][n];

        solve(maze,0,0,n-1,n-1,ans,visited,"");
        Collections.sort(ans);
        return ans;
    }

// PHONE KEYPAID PROBLEM


public void SOlve(String digits,
                  int index,
                  StringBuilder sb,
                  List<String> ans,
                  String[] mapped) {

    // Base Case
    if (index == digits.length()) {
        ans.add(sb.toString());
        return;
    }

    int value = digits.charAt(index) - '0';
    String mappingString = mapped[value];

    for (int i = 0; i < mappingString.length(); i++) {

        sb.append(mappingString.charAt(i));

        SOlve(digits, index + 1, sb, ans, mapped);

        sb.deleteCharAt(sb.length() - 1);
    }
}

public List<String> Problem(String digits) {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    String[] mapped = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    if (digits.length() == 0) {
        return ans;
    }

    SOlve(digits, 0, sb, ans, mapped);

    return ans;
}

// N QUEENS PROBLEM

public boolean iSSafe(char[][] board, int row, int col) {

        // Vertical Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal Left Up
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal Right Up
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

public void SOLVE( char[][]board,int row,List<List<String>>ans){
    if (row==board.length) {
        List<String>temp = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            temp.add(new String(board[i]));
        }
        ans.add(temp);
        return ;
    }

    for(int coln = 0;coln<board.length;coln++){
        if (iSSafe(board,row,coln)) {
            board[row][coln] = 'Q';
            SOLVE( board, row + 1, ans);
            board[row][coln] = '.';
        }
    }
}
public List<List<String>>Nqueens(int n){
    char[][]board = new char[n][n];
   for( int i = 0;i<board.length;i++){
    for(int j = 0;j<board.length;j++){
        board[i][j] = '.';
    }
   }
   int row = 0;
   List<List<String>>ans = new ArrayList<>();
   SOLVE(board,row,ans);
   return ans;
}




}
    

