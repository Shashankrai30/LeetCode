class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer>arr=new ArrayList<>();

        arr.add(0);
        for(int num:cuts){
            arr.add(num);
        }
        arr.add(n);
        Collections.sort(arr);

       int dp[][]=new int[arr.size()][arr.size()];
       for(int i=cuts.length;i>=1;i--){
            for(int j=i;j<=cuts.length;j++){
                int m=Integer.MAX_VALUE;
                for(int idx=i;idx<=j;idx++){
                    int temp=arr.get(j+1)-arr.get(i-1)+dp[i][idx-1]+dp[idx+1][j];
                    m=Math.min(temp,m);
                }
                dp[i][j]= m;
            }
        }
        return dp[1][cuts.length]; 
    }
}
//  MEMORIZATION
// class Solution {
//     public int minCost(int n, int[] cuts) {
//         ArrayList<Integer>arr=new ArrayList<>();
//         arr.add(0);
//         for(int num:cuts){
//             arr.add(num);
//         }
//         arr.add(n);
//         Collections.sort(arr);
//         Integer dp[][]=new Integer[arr.size()][arr.size()];
//         return helper(1,arr.size()-2,arr,dp);
//     }
//     public static int helper(int i,int j,ArrayList<Integer>arr,Integer dp[][]){
//         if(i>j)return 0;

//         if(dp[i][j]!=null)return dp[i][j];

//         int min=Integer.MAX_VALUE;

//         for(int idx=i;idx<=j;idx++){
//             int temp=arr.get(j+1)-arr.get(i-1)+ helper(i,idx-1,arr,dp)+helper(idx+1,j,arr,dp);
//             min=Math.min(min,temp);
//         }
//         return dp[i][j]=min;
//     }
// }