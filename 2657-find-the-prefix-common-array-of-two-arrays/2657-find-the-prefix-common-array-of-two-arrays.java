class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
       int ans[]=new int[A.length];

       if(A[0]==B[0]){
        ans[0]=1;
       } 
       
       for(int i=1;i<A.length;i++){
         for(int j=0;j<=i;j++){
            for(int k=0;k<=i;k++){
                if(A[j]==B[k]){
                    ans[i]++;
                }
            }
         }
       }

       return ans;
    }
}