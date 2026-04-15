class Solution {
    public int[] countBits(int n) {
    //    int arr[]=new int[n+1];

    //    for(int i=0;i<=n;i++){
    //     int count=0;
    //     int t=i;
    //     while(t>0){
    //         count=count+(t&1);
    //         t=t>>1;
    //     }
    //     arr[i]=count;
    //    } 

    //    return arr;

    int dp[]=new int[n+1];

    for(int i=1;i<=n;i++){
        dp[i]=dp[i>>1]+(i&1);
    }
    return dp;
    }
}