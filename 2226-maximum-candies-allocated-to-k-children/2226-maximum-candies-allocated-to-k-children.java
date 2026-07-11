class Solution {
    public int maximumCandies(int[] candies, long k) {
        int i=1;
        int j=0;

        for(int c:candies){
            j=Math.max(c,j);
        }

        while(i<=j){
            int mid=i+(j-i)/2;

            long count=0;
            for(int ind=0;ind<candies.length;ind++){
                count+=candies[ind]/mid;
            }

            if(count<k){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        return j;
    }
}