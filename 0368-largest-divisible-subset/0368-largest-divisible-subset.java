class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int dp[] = new int[nums.length];
        int parent[] = new int[nums.length];

        Arrays.fill(dp,1);

        for(int i=0;i<nums.length;i++){
            parent[i]=i;
        }

        int max=1;

        for(int curr=1;curr<nums.length;curr++){
            for(int prev=0;prev<curr;prev++){
                if(nums[curr]%nums[prev]==0 && dp[curr]<dp[prev]+1){
                    dp[curr]=dp[prev]+1;
                    parent[curr]=prev;
                }
            }

            max=Math.max(max,dp[curr]);
        }

        int ind=-1;

        for(int i=0;i<nums.length;i++){
            if(dp[i]==max) ind=i;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[ind]);

        while(ind!=parent[ind]){
            ind=parent[ind];
            ans.add(nums[ind]);
        }

        return ans;
       
    }
}