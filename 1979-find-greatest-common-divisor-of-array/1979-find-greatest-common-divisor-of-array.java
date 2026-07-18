class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return gcd(nums[0],nums[nums.length-1]);
    }

    int gcd(int x,int y){

        if(y==0) return x;

        return gcd(y,x%y);
    }
}