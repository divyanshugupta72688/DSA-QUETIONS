
class RotateImage{
    public static void Rotate(int[][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        // transpose matrix

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]  = temp;
            }
        }

        for(int  row = 0;row<n;row++){
            // reverse all rows
            int startcoln = 0;
            int endcoln = n-1;
            while (startcoln<endcoln) {
                int temp = matrix[row][startcoln];
                matrix[row][startcoln] = matrix[row][endcoln];
                matrix[row][endcoln] = temp;
                startcoln++;
                endcoln--;
            }
        }
    }

   
}