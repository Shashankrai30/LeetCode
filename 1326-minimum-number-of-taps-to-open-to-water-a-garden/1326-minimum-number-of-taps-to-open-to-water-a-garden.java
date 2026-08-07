class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int interval[][] = new int[ranges.length][2];

        for(int i=0;i<ranges.length;i++){
            interval[i][0] = Math.max(0,i-ranges[i]);
            interval[i][1] = Math.min(n,i+ranges[i]);
        }

        Arrays.sort(interval,(a,b) -> a[0]-b[0]);

        int i=0;
        int end=0;
        int farthest=0;
        int tap=0;

        while(end<n && i<interval.length){

            for(int j=0;j<interval.length && interval[j][0]<=end;j++){
                farthest=Math.max(farthest,interval[j][1]);
            }
            i++;
            if(farthest>end){
                tap++;
                end=farthest;
            }
        }

        return ( end<n)?-1:tap;
    }
}