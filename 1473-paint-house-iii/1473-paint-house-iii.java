// class Solution {
//     public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        Integer dp[][][]=new Integer[m][n+1][target+2];
//        int ans=helper(0,0,target,cost,houses,m,n,dp); 
//        return (ans>=Integer.MAX_VALUE/2)?-1:ans;
//     }

//     int helper(int ind,int prev,int target,int cost[][],int houses[],int m,int n,Integer dp[][][]){

//         if(ind==m){
//             if(target==0){
//                 return 0;
//             }
//             return Integer.MAX_VALUE/2;
//         }

//         if(target<0){
//                 return Integer.MAX_VALUE/2;
//             }

//         if(dp[ind][prev][target+1]!=null) return dp[ind][prev][target+1];

//         if(houses[ind]!=0){
//             if(houses[ind]!=prev){
//                 target--;
//             }

//             return dp[ind][prev][target+1]=helper(ind+1,houses[ind],target,cost,houses,m,n,dp);
//         }

//         int ans=Integer.MAX_VALUE/2;

//         for(int i=0;i<n;i++){
//             if(prev!=i+1){
//                 target--;
//             }
//             int temp=cost[ind][i]+helper(ind+1,i+1,target,cost,houses,m,n,dp);
//             ans=Math.min(temp,ans);
//             if(prev!=i+1){
//                 target++;
//             }
//         }

//         return dp[ind][prev][target+1]=ans;
//     }
// }
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
       Integer dp[][][]=new Integer[m][n+1][target+2];
       int ans=helper(0,0,target,cost,houses,m,n,dp); 
       return (ans>=Integer.MAX_VALUE/2)?-1:ans;
    }

    int helper(int ind,int prev,int target,int cost[][],int houses[],int m,int n,Integer dp[][][]){

        if(ind==m){
            return target==0 ? 0 : Integer.MAX_VALUE/2;
        }

        if(target<0){
            return Integer.MAX_VALUE/2;
        }

        if(dp[ind][prev][target+1]!=null) return dp[ind][prev][target+1];

        // Already painted
        if(houses[ind]!=0){
            int newTarget = target;
            if(houses[ind]!=prev){
                newTarget--;
            }

            return dp[ind][prev][target+1] =
                helper(ind+1,houses[ind],newTarget,cost,houses,m,n,dp);
        }

        int ans=Integer.MAX_VALUE/2;

        for(int i=0;i<n;i++){
            int newTarget = target;

            if(prev!=i+1){
                newTarget--;
            }

            int temp = cost[ind][i] + helper(ind+1,i+1,newTarget,cost,houses,m,n,dp);
            ans=Math.min(temp,ans);
        }

        return dp[ind][prev][target+1]=ans;
    }
}