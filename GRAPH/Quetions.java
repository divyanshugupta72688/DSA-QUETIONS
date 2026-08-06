public class Quetions {
    
// FLOOD FILL (733)

class Solution {

    int rows;
    int cols;

    public void dfs(int row, int col, int currColor, int color,
                    boolean[][] visited, int[][] image) {

        // Boundary check
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // Different color
        if (image[row][col] != currColor) {
            return;
        }

        // Already visited
        if (visited[row][col]) {
            return;
        }

        // Mark visited
        visited[row][col] = true;

        // Change color
        image[row][col] = color;

        // Explore 4 directions
        dfs(row + 1, col, currColor, color, visited, image);
        dfs(row - 1, col, currColor, color, visited, image);
        dfs(row, col + 1, currColor, color, visited, image);
        dfs(row, col - 1, currColor, color, visited, image);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        rows = image.length;
        cols = image[0].length;

        int currColor = image[sr][sc];

        // If color is already same
        if (currColor == color) {
            return image;
        }

        boolean[][] visited = new boolean[rows][cols];

        dfs(sr, sc, currColor, color, visited, image);

        return image;
    }
}


// no. of islands(200)

class solution{
    int n;
    int m;
    public int Islands(char[][]grid){
        n = grid.length;
        m = grid[0].length;
        int count =0;
        boolean[][]visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    IslandsUtil(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void IslandsUtil(int row,int coln,char[][]grid,boolean[][]visited){
        if (row < 0 || row >= n || coln < 0 || coln>= m) {
            return ;
        }

        if (grid[row][coln]=='0') {
            return;
        }
        if (visited[row][coln]) {
            return ;
        }
         visited[row][coln] = true;
        IslandsUtil(row-1, coln, grid, visited);
          IslandsUtil(row+1, coln, grid, visited);
            IslandsUtil(row, coln-1, grid, visited);
              IslandsUtil(row, coln+1, grid, visited);

    }
}


}
