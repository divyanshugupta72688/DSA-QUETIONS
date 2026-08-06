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



}
