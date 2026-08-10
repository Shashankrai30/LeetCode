class Solution {

    public int stoneGameVII(int[] stones) {

        int sum = 0;

        for (int x : stones) {
            sum += x;
        }

        Integer[][][] dp =
            new Integer[stones.length][stones.length][2];

        return helper(0, stones.length - 1, 0,
                      sum, stones, dp);
    }

    int helper(int i, int j, int turn, int sum,
               int[] stones, Integer[][][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j][turn] != null) {
            return dp[i][j][turn];
        }

        int leftSum = sum - stones[i];
        int rightSum = sum - stones[j];

        if (turn == 0) {

            int left = leftSum + helper(i + 1, j, 1, leftSum, stones, dp);

            int right = rightSum + helper(i, j - 1, 1,rightSum, stones, dp);

            return dp[i][j][turn] = Math.max(left, right);

        } else {

            int left =helper(i + 1, j, 0,leftSum, stones, dp)- leftSum;

            int right =helper(i, j - 1, 0,rightSum, stones, dp)- rightSum;

            return dp[i][j][turn] =Math.min(left, right);
        }
    }
}