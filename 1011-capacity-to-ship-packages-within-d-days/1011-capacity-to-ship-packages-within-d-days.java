class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long start=0;
        long end=0;

        for(int i=0;i<weights.length;i++){
            start=Math.max(start,weights[i]);
            end=end+weights[i];
        }

        long ans=end;

        while(start<=end){
            long mid=start+(end-start)/2;

            long d=helper(weights,mid);          

            if(d<=days){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return (int)ans;
    }

    long helper(int weights[],long mid){

        long day=1;
        long total=mid;

        for(int i=0;i<weights.length;i++){
            if(weights[i]>total){
                day++;
                total=mid-weights[i];
            }
            else{
                total=total-weights[i];
            }
        }

        return day;
    }
}