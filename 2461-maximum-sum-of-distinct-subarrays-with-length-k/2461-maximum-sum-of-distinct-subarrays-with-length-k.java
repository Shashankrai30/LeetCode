class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int r = 0;
        long maxsum = 0;   // 🔧 changed to long
        long sum = 0;      // 🔧 changed to long

        HashSet<Integer> set = new HashSet<>();

        while (r < nums.length) {

            // 🔧 FIX: properly handle duplicate
            if (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            } 
            else {
                set.add(nums[r]);
                sum += nums[r];

                if (r - l + 1 == k) {
                    maxsum = Math.max(maxsum, sum);

                    sum -= nums[l];
                    set.remove(nums[l]);
                    l++;
                    r++;
                } else {
                    r++;
                }
            }
        }

        return maxsum;
    }
}