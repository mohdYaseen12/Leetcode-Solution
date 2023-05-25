class Solution {
    public int maxPoints(int[][] points) {
        if(points.length < 2) return points.length;
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<points.length;i++){
            Map<Double,Integer> hm = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i == j ) continue;
                
                // getting point
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                double slope = 0.0;
                if(x2 - x1 == 0) slope = Double.POSITIVE_INFINITY;
                
                slope = (double)(y2 - y1) / (double)( x2 - x1 );
                
                hm.put(slope,hm.getOrDefault(slope,1)+1);
                
                max = Math.max(max,hm.get(slope));
                
            }
        }
        return max;
    }
}