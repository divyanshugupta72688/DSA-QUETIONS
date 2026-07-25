import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


}
    

