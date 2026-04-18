class Solution {
    public int mirrorDistance(int n) {
        String str = n+"";
        String reversed = new StringBuilder(str).reverse().toString();

        int rev = Integer.parseInt(reversed);

        return Math.abs(n-rev);
    }
}