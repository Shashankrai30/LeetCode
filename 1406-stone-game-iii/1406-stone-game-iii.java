class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int sum=0;

        for(int s:stoneValue){
            sum+=s;
        }
        Integer dp[][] = new Integer[stoneValue.length][2];
        int ans = helper(0,0, stoneValue,dp);

        if(ans>sum*1.0/2*1.0){
            return "Alice";
        }
        else if(ans==sum*1.0/2*1.0){
            return "Tie";
        }
        else{
            return "Bob";
        }
    }

    int helper(int i,int turn,int stone[],Integer dp[][]){

        if(i==stone.length) return 0;

        if(dp[i][turn]!=null) return dp[i][turn];

        if(turn==0){
            int take1 = stone[i]+helper(i+1,1,stone,dp);
            int take2 =  Integer.MIN_VALUE;;
            int take3 =  Integer.MIN_VALUE;;

            if(i+1<stone.length){
                take2 = stone[i]+stone[i+1]+helper(i+2,1,stone,dp);
            }

            if(i+2<stone.length){
                take3 = stone[i]+stone[i+1]+stone[i+2]+helper(i+3,1,stone,dp);
            }

            return dp[i][turn] = Math.max(take1,Math.max(take2,take3));
        }

        int take1 = helper(i+1,0,stone,dp);
        int take2 = Integer.MAX_VALUE;
        int take3 = Integer.MAX_VALUE;

        if(i+1<stone.length){
            take2 = helper(i+2,0,stone,dp);
        }

        if(i+2<stone.length){
            take3 = helper(i+3,0,stone,dp);
        }

        return dp[i][turn] = Math.min(take1,Math.min(take2,take3));
    }
}