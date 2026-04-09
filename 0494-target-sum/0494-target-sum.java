class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, target, 0, 0);
    }

    static int ways(int nums[], int target, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int add = ways(nums, target, sum + nums[index], index + 1);
        int subtract = ways(nums, target, sum - nums[index], index + 1);

        return add + subtract;
    }
}