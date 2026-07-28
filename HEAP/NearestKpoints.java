import java.util.*;

class NearestKpoints {

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



    // CONNECTING N ROPES

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
}