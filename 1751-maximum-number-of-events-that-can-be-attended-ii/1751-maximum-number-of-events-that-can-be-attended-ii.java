class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        Integer dp[][] = new Integer[events.length][k + 1];
        return helper(0, k, events, dp);
    }

    int helper(int ind, int k, int[][] events, Integer[][] dp) {
        if (ind == events.length || k == 0) return 0;

        if (dp[ind][k] != null) return dp[ind][k];

        int skip = helper(ind + 1, k, events, dp);

        int nextIndex = findNext(events, events[ind][1]);
        int take = events[ind][2] + helper(nextIndex, k - 1, events, dp);

        return dp[ind][k] = Math.max(take, skip);
    }

    int findNext(int[][] events, int endTime) {
        int l = 0, r = events.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (events[mid][0] > endTime) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}