class Solution {
    public int missingInteger(int[] nums) {
        
        int max=nums[0];
        int curr=nums[0];
        

        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            
            set.add(nums[i]);
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                curr+=nums[i];
            }
            else{
                break;
            }

            max=Math.max(max,curr);
        }

        while(set.contains(max)){
            max++;
        }

        return max;

    }
}