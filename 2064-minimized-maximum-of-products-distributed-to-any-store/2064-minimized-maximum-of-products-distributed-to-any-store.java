class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int i=1;

        int j=0;
        for(int num:quantities){
            j=Math.max(num,j);
        }

        while(i<=j){
            int mid=i+(j-i)/2;

            int count=0;

            for(int ind=0;ind<quantities.length;ind++){

                if(quantities[ind]%mid==0){
                    count+=quantities[ind]/mid;
                }
                else{
                    count+=quantities[ind]/mid+1;
                }
            }

            if(count>n){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return i;
    }
}