public class MaximumOnes {
    static int[] MaximumOnesInRow(int[][]mat){
        int rowindex= 0;
        int maxone = 0;
        for(int i = 0;i<mat.length;i++){
            int count = 0;
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if (count>maxone) {
                maxone = count;
                rowindex = i;
            }
        }
        return new int[]{rowindex,maxone};
    }
}
