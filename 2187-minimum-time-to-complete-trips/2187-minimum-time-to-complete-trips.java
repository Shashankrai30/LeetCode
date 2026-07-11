class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long i=1;
        long j=Integer.MAX_VALUE;

        for(int t:time){
            j=Math.min(j,t);
        }

        j*=totalTrips;

        while(i<=j){
            long mid=i+(j-i)/2;
            long count=0;

            for(int n:time){
                count+=mid/n;
            }

            if(count>=totalTrips){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        return i;
    }
}