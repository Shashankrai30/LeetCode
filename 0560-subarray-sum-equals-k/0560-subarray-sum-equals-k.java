class Solution {
    public int subarraySum(int[] nums, int k) {
        int pre[]=new int[nums.length];

        pre[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int count=0;

        for(int num:pre){
            count=count+map.getOrDefault(num-k,0);
            map.put(num,map.getOrDefault(num,0)+1);
        }

        return count;
    }
}