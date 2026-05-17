class Solution {
    public boolean canReach(int[] nums, int start) {
        boolean visited[] = new boolean[nums.length];
        return helper(start, nums, visited);
    }

    boolean helper(int i, int nums[], boolean visited[]) {
        if (i < 0 || i >= nums.length) return false;
        if (visited[i]) return false;   
        if (nums[i] == 0) return true;

        visited[i] = true; 

        return helper(i + nums[i], nums, visited) || 
               helper(i - nums[i], nums, visited);
    }
}