public class Transpose {
    static int[][] Tra(int[][]mat){
        int n = mat.length;
        int m = mat[0].length;
        // for new Array
        int newrow = m;
        int newcoln = n;

        int[][] ans = new int[newrow][newcoln];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans[j][i] = mat[i][j];
            }
        }
        return ans;
    }
}
