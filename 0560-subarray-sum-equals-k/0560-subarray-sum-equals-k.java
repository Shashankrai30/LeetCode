class Solution {
    public int subarraySum(int[] nums, int k) {

        int pre[]=new int[nums.length];
        pre[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            pre[i]=nums[i]+pre[i-1];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int ans=0;

        for(int num:pre){
            int tar=num-k;

            ans=ans+map.getOrDefault(tar,0);

            map.put(num,map.getOrDefault(num,0)+1);
        }

        return ans;
    }
}