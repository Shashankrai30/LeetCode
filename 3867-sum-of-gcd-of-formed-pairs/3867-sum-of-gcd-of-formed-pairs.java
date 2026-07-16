class Solution {
    public long gcdSum(int[] nums) {
        
        int pre[] = new int[nums.length];
        pre[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            pre[i]=Math.max(pre[i-1],nums[i]);
        }

        int prefixGcd[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            prefixGcd[i] = gcd(nums[i],pre[i]);
        }
        
        Arrays.sort(prefixGcd);

        long sum=0;
        int i=0;
        int j=nums.length-1;

        while(i<j){
            sum+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    int gcd(int x,int y){
        if(y==0) return x;

        return gcd(y,x%y);
    }
}