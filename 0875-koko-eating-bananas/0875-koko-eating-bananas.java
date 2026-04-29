class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start=1;
        int end=piles[piles.length-1];

        int ans=Integer.MAX_VALUE;

        while(start<=end){
            int mid=start+(end-start)/2;
            long hour=0;

            for(int i=0;i<piles.length;i++){
                if(piles[i]%mid==0){
                    hour=hour+piles[i]/mid;
                }
                else{
                    hour=hour+piles[i]/mid+1;
                }
            }

            if(hour<=h){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return ans;
    }
}