class Solution {
    public int stoneGameVII(int[] stones) {

        int n = stones.length;

        int prefix[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        Integer dp[][][] = new Integer[n][n][2];

        return helper(0, n - 1, 0, prefix, stones, dp);
    }

    int helper(int i, int j, int turn,
               int prefix[], int stones[], Integer dp[][][]) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j][turn] != null) {
            return dp[i][j][turn];
        }

        if (turn == 0) { 
            int leftSum = prefix[j + 1] - prefix[i + 1];

            int rightSum = prefix[j] - prefix[i];

            int left = leftSum + helper(i + 1, j, 1, prefix, stones, dp);

            int right = rightSum + helper(i, j - 1, 1, prefix, stones, dp);

            return dp[i][j][turn] = Math.max(left, right);

        } else {

            int leftSum = prefix[j + 1] - prefix[i + 1];

            int rightSum = prefix[j] - prefix[i];

            int left = helper(i + 1, j, 0, prefix, stones, dp)- leftSum;

            int right = helper(i, j - 1, 0, prefix, stones, dp)- rightSum;

            return dp[i][j][turn] = Math.min(left, right);
        }
    }
}