import java.util.*;


// isme saare uwtion implement kiye gaye hai jo maine leetcode aur geeks pe solve kiye hai

class NearestKpoints {

    // nearest point to origin

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distsq;

        public Point(int x, int y, int distsq) {
            this.x = x;
            this.y = y;
            this.distsq = distsq;
        }

        @Override
        public int compareTo(Point p2) {
            // Max Heap
            return p2.distsq - this.distsq;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int distsq = x*x + y*y;

            pq.add(new Point(x, y, distsq));

            // keep only k closest points
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point p = pq.remove();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }

// connecting n ropes

    public int ConnectingNRopes(int[]ropes){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i = 0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size()>1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost = cost+ min1+min2;
            pq.add(min1+min2);
        }
        return cost;
    }


    //  WEAKEST ARMY SOLDIER

    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        public Row(int soldiers,int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row r2){
            if (this.soldiers == r2.soldiers) {
                return this.idx  - r2.idx;
            }else{
                return this.soldiers-r2.soldiers;
            }
        }
    }
   
   public int[] Weakest(int[][]mat,int k){
    PriorityQueue<Row>pq = new PriorityQueue<>();
    for(int i = 0;i<mat.length;i++){
        int count = 0;
        for(int j = 0;j<mat[0].length;j++){
            if (mat[i][j]==1) {
                count++;
            }
        }
        pq.add(new Row(count, i));
    }
    int[]ans = new int[k];
    for(int i = 0;i<k;i++){
        ans[i] = pq.remove().idx;
    }
    return ans;
   }
   
   
   
   // SLIDING WINDOW MAXIMUM 

   // BRUTE FORCE APPROACH

   public int[] Maximum(int[]nums,int k){
        int n = nums.length;
        int[]ans = new int[n-k+1];
        for(int i = 0;i<=n-k;i++){
            int max = nums[i];
            for(int j = i;j<i+k;j++){
                if (nums[j]>max) {
                    max = nums[j];
                }
            }
            ans[i] = max;
        }
        return ans;
   }
    
   
   
   
   public static void main(String[] args) {

        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };

        int k = 2;

        NearestKpoints obj = new NearestKpoints();

        int[][] ans = obj.kClosest(points, k);

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i][0]+" "+ans[i][1]);
        }
    }



}