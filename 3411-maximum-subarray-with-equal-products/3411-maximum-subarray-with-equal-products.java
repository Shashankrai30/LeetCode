class Solution {
    public int maxLength(int[] nums) {
        
        int n=nums.length;

        int max=1;

        for(int i=0; i<n; i++){
            
            long pro=1;
            long lcm=1;
            long gcd=0;

            for(int j=i; j<n; j++){

                pro=pro*nums[j];

                gcd=gcd(gcd,nums[j]);
                lcm=lcm(lcm,nums[j]);

                if(pro==lcm*gcd){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    public long gcd(long a, long b){

        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }

    public long lcm(long a, long b){
        
        return (a*b)/gcd(a,b);
    }
}