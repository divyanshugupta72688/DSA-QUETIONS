public class twodarray {
    public static void main(String[] args) {
        int[][]matrix = {
            {12,36,41},
            {10,3,48},
            {1,2,99},
        };
        int max = matrix[0][0];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if (matrix[i][j]>max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
