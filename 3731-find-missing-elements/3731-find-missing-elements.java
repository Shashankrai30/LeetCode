class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);

        int low=nums[0]+1;
        int high=nums[nums.length-1];

        List<Integer> ans = new ArrayList<>();
        int i=1;

        while(low<high){
            if(nums[i]!=low){
                ans.add(low);
                low++;
            }
            else{
                low++;
                i++;
            }
        }

        return ans;
    }
}