class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        long i=0;
        long j=Long.MAX_VALUE;

        for(int r:ranks){
            j=Math.min(r,j);
        }

        j=j*cars*cars;

        while(i<=j){
            long mid=i+(j-i)/2;

            long count=0;

            for(int r:ranks){
                count+=(int)Math.sqrt(mid/r);
            }

            if(count>=cars){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }

        return i;
    }
}