class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set=new HashSet<>();

       for(int num:nums){
        set.add(num);
       }

       int ans=0;

       for(int num:set){
        if(!set.contains(num-1)){
            int count=1;
            int x=num;

            while(set.contains(x+1)){
                count++;
                x++;
            }
            ans=Math.max(count,ans);
        }
       }

       return ans;
    }
}