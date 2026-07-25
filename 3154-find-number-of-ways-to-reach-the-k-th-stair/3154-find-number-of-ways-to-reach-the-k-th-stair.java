class Solution {

    HashMap<Long, Integer> memo = new HashMap<>();

    public int waysToReachStair(int k) {
        return dfs(1, k, 0, 0);
    }

    private int dfs(int i, int k, int prev, int jump) {

        if (i > k + 1) return 0;

        long key = (((long) i) << 6) | ((long) jump << 1) | prev;

        if (memo.containsKey(key))
            return memo.get(key);

        int ans = 0;

        if (i == k)
            ans++;

        // Move back
        if (i > 0 && prev == 0)
            ans += dfs(i - 1, k, 1, jump);

        // Move forward
        ans += dfs(i + (1 << jump), k, 0, jump + 1);

        memo.put(key, ans);
        return ans;
    }
}