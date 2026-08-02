class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b)->a[0]-b[0]);

        int count=1;

        int range[] = new int[]{points[0][0],points[0][1]};

        for(int i=1;i<points.length;i++){
            if(points[i][0]>=range[0] && points[i][0]<=range[1]){
                range[0]=points[i][0];
                if(points[i][1]<range[1]){
                    range[1]=points[i][1];
                }
            }
            else{
                count++;
                range[0]=points[i][0];
                range[1]=points[i][1];
            }
        }

        return count;
    }
}