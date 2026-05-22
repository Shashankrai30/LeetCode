class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int ans = -1;

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                ans = mid;
                break;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                ans = mid - 1;
                break;
            } else if (nums[mid] > nums[i]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        if (ans == -1) {
            ans = nums.length - 1;
        }
        int k = 0;
        int l = ans;
        while (k <= l) {
            int mid = k + (l - k) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                k = mid + 1;
            } else {
                l = mid - 1;
            }
        }
        int a = ans + 1;
        int m = nums.length - 1;
        while (a <= m) {
            int mid = a + (m - a) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                a = mid + 1;
            } else {
                m = mid - 1;
            }
        }

        return -1;
    }
}
