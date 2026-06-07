class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {

        if(intervals==null || intervals.length==0) return 0;

        long bulbs=(brightness+2)/3;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        long total=0;
        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                total+=(end-start+1);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }

        total+=(end-start+1);

        return bulbs*total;
        
    }
}