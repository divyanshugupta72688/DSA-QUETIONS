public class Rotate {
    static void Image(int[][]mat){
        // transpose matrix

        for(int i = 0;i<mat.length;i++){
            for(int j = i+1;j<mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i]  = temp;
            }
        }
        for(int i = 0;i<mat.length;i++){
        int startColn = 0;
        int endColn = mat[0].length;
        while (startColn<=endColn) {
            int temp = mat[i][startColn];
            mat[i][startColn] = mat[i][endColn];
            mat[i][endColn] = temp;
            startColn++;
            endColn--;
        }   
        }
    }
}
