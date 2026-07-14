import java.util.*;

public class Spiral {

    static List<Integer> SpiralMatrix(int[][] mat) {

        List<Integer> res = new ArrayList<>();

        int m = mat.length;
        int n = mat[0].length;

        int startrow = 0;
        int endrow = m - 1;

        int startcoln = 0;
        int endcoln = n - 1;

        while (startrow <= endrow && startcoln <= endcoln) {

            // Top Row
            for (int coln = startcoln; coln <= endcoln; coln++) {
                res.add(mat[startrow][coln]);
            }
            startrow++;

            // Right Column
            for (int row = startrow; row <= endrow; row++) {
                res.add(mat[row][endcoln]);
            }
            endcoln--;

            // Bottom Row
            if (startrow <= endrow) {
                for (int coln = endcoln; coln >= startcoln; coln--) {
                    res.add(mat[endrow][coln]);
                }
                endrow--;
            }

            // Left Column
            if (startcoln <= endcoln) {
                for (int row = endrow; row >= startrow; row--) {
                    res.add(mat[row][startcoln]);
                }
                startcoln++;
            }
        }

        return res;
    }
}